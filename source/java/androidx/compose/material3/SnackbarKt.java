package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.LayoutIdKt;
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
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0099\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = Dp.constructor-impl(600);
    private static final float HeightToFirstLine = Dp.constructor-impl(30);
    private static final float HorizontalSpacing = Dp.constructor-impl(16);
    private static final float SeparateButtonExtraY = Dp.constructor-impl(2);
    private static final float SnackbarVerticalPadding = Dp.constructor-impl(6);
    private static final float LongButtonVerticalOffset = Dp.constructor-impl(12);

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019b  */
    /* renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2957SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Shape shape, long j, long j2, long j3, long j4, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        long j5;
        long j6;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function26;
        boolean z2;
        Shape shape2;
        long j7;
        long j8;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        Modifier modifier2;
        final boolean z3;
        final Shape shape3;
        long j9;
        final long j10;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1235788955);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)101@4932L5,102@4984L5,103@5034L12,104@5097L18,105@5173L25,108@5244L1420:Snackbar.kt#uh7d8r");
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
            function24 = function2;
            i3 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function25 = function22;
                i3 |= startRestartGroup.changedInstance(function25) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0 && startRestartGroup.changed(shape)) {
                            i7 = Fields.Clip;
                            i3 |= i7;
                        }
                        i7 = Fields.Shape;
                        i3 |= i7;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j5 = j;
                            if (startRestartGroup.changed(j5)) {
                                i6 = Fields.RenderEffect;
                                i3 |= i6;
                            }
                        } else {
                            j5 = j;
                        }
                        i6 = 65536;
                        i3 |= i6;
                    } else {
                        j5 = j;
                    }
                    if ((i & 1572864) == 0) {
                        i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j2)) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i) != 0) {
                        j6 = j4;
                        i3 |= ((i2 & Fields.RotationX) == 0 && startRestartGroup.changed(j6)) ? 67108864 : 33554432;
                    } else {
                        j6 = j4;
                    }
                    if ((i2 & Fields.RotationY) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i8 != 0 ? Modifier.INSTANCE : modifier;
                                if (i9 != 0) {
                                    function24 = null;
                                }
                                function26 = i4 == 0 ? function25 : null;
                                z2 = i5 != 0 ? false : z;
                                if ((i2 & 16) != 0) {
                                    shape2 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    shape2 = shape;
                                }
                                if ((i2 & 32) != 0) {
                                    j5 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    j7 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    j7 = j2;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    j8 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    j8 = j3;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                    j6 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & Fields.SpotShadowColor) != 0) {
                                    i3 &= -29360129;
                                }
                                if ((i2 & Fields.RotationX) != 0) {
                                    i3 &= -234881025;
                                }
                                companion = modifier;
                                z2 = z;
                                shape2 = shape;
                                j7 = j2;
                                j8 = j3;
                                function26 = function25;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:107)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                            final long j12 = j8;
                            final long j13 = j6;
                            final boolean z4 = z2;
                            Function2<? super Composer, ? super Integer, Unit> function210 = function26;
                            int i10 = (i3 & 14) | 12779520;
                            int i11 = i3 >> 9;
                            SurfaceKt.m3043SurfaceT9BRK9s(companion, shape2, j5, j7, 0.0f, SnackbarTokens.INSTANCE.m3898getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                                    ComposerKt.sourceInformation(composer2, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                                    if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                                        }
                                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                                        final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                                        final Function2<Composer, Integer, Unit> function211 = function28;
                                        final Function2<Composer, Integer, Unit> function212 = function23;
                                        final Function2<Composer, Integer, Unit> function213 = function29;
                                        final long j14 = j12;
                                        final long j15 = j13;
                                        final boolean z5 = z4;
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i13) {
                                                ComposerKt.sourceInformation(composer3, "C:Snackbar.kt#uh7d8r");
                                                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                                    }
                                                    if (function211 == null) {
                                                        composer3.startReplaceableGroup(-2104362406);
                                                        ComposerKt.sourceInformation(composer3, "119@5760L278");
                                                        SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, null, function213, fromToken2, j14, j15, composer3, 48);
                                                        composer3.endReplaceableGroup();
                                                    } else if (z5) {
                                                        composer3.startReplaceableGroup(-2104362092);
                                                        ComposerKt.sourceInformation(composer3, "127@6074L255");
                                                        SnackbarKt.m2955NewLineButtonSnackbarkKq0p4A(function212, function211, function213, fromToken2, j14, j15, composer3, 0);
                                                        composer3.endReplaceableGroup();
                                                    } else {
                                                        composer3.startReplaceableGroup(-2104361812);
                                                        ComposerKt.sourceInformation(composer3, "135@6354L280");
                                                        SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, function211, function213, fromToken2, j14, j15, composer3, 0);
                                                        composer3.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), composer2, ProvidedValue.$stable | 0 | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, i10 | (i11 & 112) | (i11 & 896) | (i11 & 7168), 80);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function27 = function210;
                            modifier2 = companion;
                            z3 = z2;
                            shape3 = shape2;
                            j9 = j6;
                            j10 = j7;
                            j11 = j8;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z;
                            shape3 = shape;
                            function27 = function25;
                            j9 = j6;
                            j10 = j2;
                            j11 = j3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function24;
                            final long j14 = j5;
                            final long j15 = j9;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
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
                                    SnackbarKt.m2957SnackbareQBnUkQ(Modifier.this, function211, function27, z3, shape3, j14, j10, j11, j15, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & Fields.SpotShadowColor) != 0) {
                    }
                    if ((i2 & Fields.RotationX) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function282 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function292 = function26;
                    final long j122 = j8;
                    final long j132 = j6;
                    final boolean z42 = z2;
                    Function2<? super Composer, ? super Integer, Unit> function2102 = function26;
                    int i102 = (i3 & 14) | 12779520;
                    int i112 = i3 >> 9;
                    SurfaceKt.m3043SurfaceT9BRK9s(companion, shape2, j5, j7, 0.0f, SnackbarTokens.INSTANCE.m3898getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                            ComposerKt.sourceInformation(composer2, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                            if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                                }
                                TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                                final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                                ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                                final Function2<? super Composer, ? super Integer, Unit> function2112 = function282;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                                final Function2<? super Composer, ? super Integer, Unit> function213 = function292;
                                final long j142 = j122;
                                final long j152 = j132;
                                final boolean z5 = z42;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i13) {
                                        ComposerKt.sourceInformation(composer3, "C:Snackbar.kt#uh7d8r");
                                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                            }
                                            if (function2112 == null) {
                                                composer3.startReplaceableGroup(-2104362406);
                                                ComposerKt.sourceInformation(composer3, "119@5760L278");
                                                SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, null, function213, fromToken2, j142, j152, composer3, 48);
                                                composer3.endReplaceableGroup();
                                            } else if (z5) {
                                                composer3.startReplaceableGroup(-2104362092);
                                                ComposerKt.sourceInformation(composer3, "127@6074L255");
                                                SnackbarKt.m2955NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                                composer3.endReplaceableGroup();
                                            } else {
                                                composer3.startReplaceableGroup(-2104361812);
                                                ComposerKt.sourceInformation(composer3, "135@6354L280");
                                                SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                                composer3.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, ProvidedValue.$stable | 0 | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, i102 | (i112 & 112) | (i112 & 896) | (i112 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function27 = function2102;
                    modifier2 = companion;
                    z3 = z2;
                    shape3 = shape2;
                    j9 = j6;
                    j10 = j7;
                    j11 = j8;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i & 24576) == 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((100663296 & i) != 0) {
                }
                if ((i2 & Fields.RotationY) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) != 0) {
                }
                if ((i2 & Fields.RotationX) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function2822 = function24;
                final Function2<? super Composer, ? super Integer, Unit> function2922 = function26;
                final long j1222 = j8;
                final long j1322 = j6;
                final boolean z422 = z2;
                Function2<? super Composer, ? super Integer, Unit> function21022 = function26;
                int i1022 = (i3 & 14) | 12779520;
                int i1122 = i3 >> 9;
                SurfaceKt.m3043SurfaceT9BRK9s(companion, shape2, j5, j7, 0.0f, SnackbarTokens.INSTANCE.m3898getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                        ComposerKt.sourceInformation(composer2, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                            }
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                            final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                            ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                            final Function2<? super Composer, ? super Integer, Unit> function2112 = function2822;
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function213 = function2922;
                            final long j142 = j1222;
                            final long j152 = j1322;
                            final boolean z5 = z422;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ComposerKt.sourceInformation(composer3, "C:Snackbar.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                        }
                                        if (function2112 == null) {
                                            composer3.startReplaceableGroup(-2104362406);
                                            ComposerKt.sourceInformation(composer3, "119@5760L278");
                                            SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, null, function213, fromToken2, j142, j152, composer3, 48);
                                            composer3.endReplaceableGroup();
                                        } else if (z5) {
                                            composer3.startReplaceableGroup(-2104362092);
                                            ComposerKt.sourceInformation(composer3, "127@6074L255");
                                            SnackbarKt.m2955NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                            composer3.endReplaceableGroup();
                                        } else {
                                            composer3.startReplaceableGroup(-2104361812);
                                            ComposerKt.sourceInformation(composer3, "135@6354L280");
                                            SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                            composer3.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, ProvidedValue.$stable | 0 | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, i1022 | (i1122 & 112) | (i1122 & 896) | (i1122 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                }
                function27 = function21022;
                modifier2 = companion;
                z3 = z2;
                shape3 = shape2;
                j9 = j6;
                j10 = j7;
                j11 = j8;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function25 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) != 0) {
            }
            if ((i2 & Fields.RotationY) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if ((i2 & Fields.RotationX) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function28222 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function29222 = function26;
            final long j12222 = j8;
            final long j13222 = j6;
            final boolean z4222 = z2;
            Function2<? super Composer, ? super Integer, Unit> function210222 = function26;
            int i10222 = (i3 & 14) | 12779520;
            int i11222 = i3 >> 9;
            SurfaceKt.m3043SurfaceT9BRK9s(companion, shape2, j5, j7, 0.0f, SnackbarTokens.INSTANCE.m3898getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                    ComposerKt.sourceInformation(composer2, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                        }
                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                        final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                        final Function2<? super Composer, ? super Integer, Unit> function2112 = function28222;
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                        final Function2<? super Composer, ? super Integer, Unit> function213 = function29222;
                        final long j142 = j12222;
                        final long j152 = j13222;
                        final boolean z5 = z4222;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ComposerKt.sourceInformation(composer3, "C:Snackbar.kt#uh7d8r");
                                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                    }
                                    if (function2112 == null) {
                                        composer3.startReplaceableGroup(-2104362406);
                                        ComposerKt.sourceInformation(composer3, "119@5760L278");
                                        SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, null, function213, fromToken2, j142, j152, composer3, 48);
                                        composer3.endReplaceableGroup();
                                    } else if (z5) {
                                        composer3.startReplaceableGroup(-2104362092);
                                        ComposerKt.sourceInformation(composer3, "127@6074L255");
                                        SnackbarKt.m2955NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(-2104361812);
                                        ComposerKt.sourceInformation(composer3, "135@6354L280");
                                        SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                        composer3.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, ProvidedValue.$stable | 0 | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, i10222 | (i11222 & 112) | (i11222 & 896) | (i11222 & 7168), 80);
            if (ComposerKt.isTraceInProgress()) {
            }
            function27 = function210222;
            modifier2 = companion;
            z3 = z2;
            shape3 = shape2;
            j9 = j6;
            j10 = j7;
            j11 = j8;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function24 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) != 0) {
        }
        if ((i2 & Fields.RotationY) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if ((i2 & Fields.RotationX) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function282222 = function24;
        final Function2<? super Composer, ? super Integer, Unit> function292222 = function26;
        final long j122222 = j8;
        final long j132222 = j6;
        final boolean z42222 = z2;
        Function2<? super Composer, ? super Integer, Unit> function2102222 = function26;
        int i102222 = (i3 & 14) | 12779520;
        int i112222 = i3 >> 9;
        SurfaceKt.m3043SurfaceT9BRK9s(companion, shape2, j5, j7, 0.0f, SnackbarTokens.INSTANCE.m3898getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                ComposerKt.sourceInformation(composer2, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1829663446, i12, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                    }
                    TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                    final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                    ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                    final Function2<? super Composer, ? super Integer, Unit> function2112 = function282222;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                    final Function2<? super Composer, ? super Integer, Unit> function213 = function292222;
                    final long j142 = j122222;
                    final long j152 = j132222;
                    final boolean z5 = z42222;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) provides, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C:Snackbar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(835891690, i13, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                }
                                if (function2112 == null) {
                                    composer3.startReplaceableGroup(-2104362406);
                                    ComposerKt.sourceInformation(composer3, "119@5760L278");
                                    SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, null, function213, fromToken2, j142, j152, composer3, 48);
                                    composer3.endReplaceableGroup();
                                } else if (z5) {
                                    composer3.startReplaceableGroup(-2104362092);
                                    ComposerKt.sourceInformation(composer3, "127@6074L255");
                                    SnackbarKt.m2955NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(-2104361812);
                                    ComposerKt.sourceInformation(composer3, "135@6354L280");
                                    SnackbarKt.m2956OneRowSnackbarkKq0p4A(function212, function2112, function213, fromToken2, j142, j152, composer3, 0);
                                    composer3.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, ProvidedValue.$stable | 0 | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, i102222 | (i112222 & 112) | (i112222 & 896) | (i112222 & 7168), 80);
        if (ComposerKt.isTraceInProgress()) {
        }
        function27 = function2102222;
        modifier2 = companion;
        z3 = z2;
        shape3 = shape2;
        j9 = j6;
        j10 = j7;
        j11 = j8;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ff  */
    /* renamed from: Snackbar-sDKtq54, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2958SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, long j4, long j5, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        long j6;
        long j7;
        Modifier.Companion companion;
        boolean z3;
        Shape shape3;
        long j8;
        long j9;
        final long j10;
        long j11;
        long j12;
        long j13;
        final String actionLabel;
        final SnackbarData snackbarData2;
        long j14;
        boolean z4;
        ComposableLambda composableLambda;
        long j15;
        final boolean z5;
        final Shape shape4;
        ScopeUpdateScope endRestartGroup;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)203@9555L5,204@9607L5,205@9657L12,206@9713L11,207@9775L18,208@9851L25,238@10864L456:Snackbar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
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
                            i7 = Fields.CameraDistance;
                            i3 |= i7;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i7 = Fields.RotationZ;
                    i3 |= i7;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j6 = j;
                        if (startRestartGroup.changed(j6)) {
                            i6 = Fields.Clip;
                            i3 |= i6;
                        }
                    } else {
                        j6 = j;
                    }
                    i6 = Fields.Shape;
                    i3 |= i6;
                } else {
                    j6 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j7 = j2;
                        if (startRestartGroup.changed(j7)) {
                            i5 = Fields.RenderEffect;
                            i3 |= i5;
                        }
                    } else {
                        j7 = j2;
                    }
                    i5 = 65536;
                    i3 |= i5;
                } else {
                    j7 = j2;
                }
                if ((1572864 & i) == 0) {
                    i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j3)) ? 1048576 : Fields.BlendMode;
                }
                if ((i & 12582912) == 0) {
                    i3 |= ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(j4)) ? 8388608 : 4194304;
                }
                if ((100663296 & i) == 0) {
                    i3 |= ((i2 & Fields.RotationX) == 0 && startRestartGroup.changed(j5)) ? 67108864 : 33554432;
                }
                if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        z3 = i4 != 0 ? false : z2;
                        if ((i2 & 8) != 0) {
                            shape3 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            j8 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            j8 = j6;
                        }
                        if ((i2 & 32) != 0) {
                            j9 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            j9 = j7;
                        }
                        if ((i2 & 64) != 0) {
                            j10 = SnackbarDefaults.INSTANCE.getActionColor(startRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            j10 = j3;
                        }
                        if ((i2 & Fields.SpotShadowColor) != 0) {
                            j11 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            j11 = j4;
                        }
                        if ((i2 & Fields.RotationX) != 0) {
                            i3 &= -234881025;
                            j13 = j11;
                            j12 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                        } else {
                            j12 = j5;
                            j13 = j11;
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
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        if ((i2 & Fields.SpotShadowColor) != 0) {
                            i3 &= -29360129;
                        }
                        if ((i2 & Fields.RotationX) != 0) {
                            i3 &= -234881025;
                        }
                        j13 = j4;
                        j12 = j5;
                        companion = modifier2;
                        z3 = z2;
                        shape3 = shape2;
                        j8 = j6;
                        j9 = j7;
                        j10 = j3;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274621471, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:209)");
                    }
                    actionLabel = snackbarData.getVisuals().getActionLabel();
                    if (actionLabel != null) {
                        snackbarData2 = snackbarData;
                        Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
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
                                ComposerKt.sourceInformation(composer2, "C214@10104L44,215@10176L32,213@10052L219:Snackbar.kt#uh7d8r");
                                if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1378313599, i9, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:213)");
                                    }
                                    ButtonColors m2261textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2261textButtonColorsro_MJ88(0L, j10, 0L, 0L, composer2, 24576, 13);
                                    composer2.startReplaceableGroup(-2057496839);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):Snackbar.kt#9igjgp");
                                    boolean changed = composer2.changed(snackbarData2);
                                    final SnackbarData snackbarData3 = snackbarData2;
                                    Object rememberedValue = composer2.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(0);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m2961invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: collision with other method in class */
                                            public final void m2961invoke() {
                                                SnackbarData.this.performAction();
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue);
                                    }
                                    composer2.endReplaceableGroup();
                                    final String str = actionLabel;
                                    ButtonKt.TextButton((Function0) rememberedValue, null, false, null, m2261textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda(composer2, 521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(RowScope rowScope, Composer composer3, int i10) {
                                            ComposerKt.sourceInformation(composer3, "C216@10238L17:Snackbar.kt#uh7d8r");
                                            if ((i10 & 17) == 16 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(521110564, i10, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:216)");
                                            }
                                            TextKt.m3199Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 805306368, 494);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        };
                        j14 = j10;
                        z4 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1378313599, true, function2);
                    } else {
                        snackbarData2 = snackbarData;
                        j14 = j10;
                        z4 = true;
                        composableLambda = null;
                    }
                    int i9 = i3 << 3;
                    m2957SnackbareQBnUkQ(PaddingKt.m1064padding3ABfNKs(companion, Dp.constructor-impl(12)), composableLambda, snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(startRestartGroup, -1812633777, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            ComposerKt.sourceInformation(composer2, "C226@10513L26,225@10471L330:Snackbar.kt#uh7d8r");
                            if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1812633777, i10, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:225)");
                                }
                                composer2.startReplaceableGroup(-2057496502);
                                ComposerKt.sourceInformation(composer2, "CC(remember):Snackbar.kt#9igjgp");
                                boolean changed = composer2.changed(SnackbarData.this);
                                final SnackbarData snackbarData3 = SnackbarData.this;
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m2962invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: collision with other method in class */
                                        public final void m2962invoke() {
                                            SnackbarData.this.dismiss();
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2425getLambda1$material3_release(), composer2, 196608, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }) : null, z3, shape3, j8, j9, j13, j12, ComposableLambdaKt.composableLambda(startRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            ComposerKt.sourceInformation(composer2, "C248@11278L34:Snackbar.kt#uh7d8r");
                            if ((i10 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266389126, i10, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:248)");
                            }
                            TextKt.m3199Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, (i9 & 3670016) | (i9 & 7168) | 805306368 | (57344 & i9) | (458752 & i9) | (29360128 & i3) | (i3 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j15 = j14;
                    z5 = z3;
                    shape4 = shape3;
                    modifier2 = companion;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j13 = j4;
                    j12 = j5;
                    z5 = z2;
                    shape4 = shape2;
                    j8 = j6;
                    j9 = j7;
                    j15 = j3;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j16 = j8;
                    final long j17 = j9;
                    final long j18 = j15;
                    final long j19 = j13;
                    final long j20 = j12;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
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
                            SnackbarKt.m2958SnackbarsDKtq54(SnackbarData.this, modifier3, z5, shape4, j16, j17, j18, j19, j20, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) == 0) {
            }
            if ((38347923 & i3) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if ((i2 & Fields.RotationX) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            actionLabel = snackbarData.getVisuals().getActionLabel();
            if (actionLabel != null) {
            }
            if (snackbarData.getVisuals().getWithDismissAction()) {
            }
            int i92 = i3 << 3;
            m2957SnackbareQBnUkQ(PaddingKt.m1064padding3ABfNKs(companion, Dp.constructor-impl(12)), composableLambda, snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(startRestartGroup, -1812633777, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    ComposerKt.sourceInformation(composer2, "C226@10513L26,225@10471L330:Snackbar.kt#uh7d8r");
                    if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1812633777, i10, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:225)");
                        }
                        composer2.startReplaceableGroup(-2057496502);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Snackbar.kt#9igjgp");
                        boolean changed = composer2.changed(SnackbarData.this);
                        final SnackbarData snackbarData3 = SnackbarData.this;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2962invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m2962invoke() {
                                    SnackbarData.this.dismiss();
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2425getLambda1$material3_release(), composer2, 196608, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }) : null, z3, shape3, j8, j9, j13, j12, ComposableLambdaKt.composableLambda(startRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    ComposerKt.sourceInformation(composer2, "C248@11278L34:Snackbar.kt#uh7d8r");
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, i10, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:248)");
                    }
                    TextKt.m3199Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, (i92 & 3670016) | (i92 & 7168) | 805306368 | (57344 & i92) | (458752 & i92) | (29360128 & i3) | (i3 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j15 = j14;
            z5 = z3;
            shape4 = shape3;
            modifier2 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
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
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) == 0) {
        }
        if ((38347923 & i3) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if ((i2 & Fields.RotationX) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        actionLabel = snackbarData.getVisuals().getActionLabel();
        if (actionLabel != null) {
        }
        if (snackbarData.getVisuals().getWithDismissAction()) {
        }
        int i922 = i3 << 3;
        m2957SnackbareQBnUkQ(PaddingKt.m1064padding3ABfNKs(companion, Dp.constructor-impl(12)), composableLambda, snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(startRestartGroup, -1812633777, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i10) {
                ComposerKt.sourceInformation(composer2, "C226@10513L26,225@10471L330:Snackbar.kt#uh7d8r");
                if ((i10 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1812633777, i10, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:225)");
                    }
                    composer2.startReplaceableGroup(-2057496502);
                    ComposerKt.sourceInformation(composer2, "CC(remember):Snackbar.kt#9igjgp");
                    boolean changed = composer2.changed(SnackbarData.this);
                    final SnackbarData snackbarData3 = SnackbarData.this;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2962invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2962invoke() {
                                SnackbarData.this.dismiss();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2425getLambda1$material3_release(), composer2, 196608, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }) : null, z3, shape3, j8, j9, j13, j12, ComposableLambdaKt.composableLambda(startRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i10) {
                ComposerKt.sourceInformation(composer2, "C248@11278L34:Snackbar.kt#uh7d8r");
                if ((i10 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1266389126, i10, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:248)");
                }
                TextKt.m3199Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, (i922 & 3670016) | (i922 & 7168) | 805306368 | (57344 & i922) | (458752 & i922) | (29360128 & i3) | (i3 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j15 = j14;
        z5 = z3;
        shape4 = shape3;
        modifier2 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2955NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)261@11595L1173:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? Fields.RenderEffect : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:260)");
            }
            Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1127widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916592009, "C271@11902L171,276@12083L679:Snackbar.kt#uh7d8r");
            Modifier m876paddingFromBaselineVpY3zN4 = AlignmentLineKt.m876paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset);
            float f = HorizontalSpacingButtonSide;
            Modifier m1068paddingqDBjuR0$default2 = PaddingKt.m1068paddingqDBjuR0$default(m876paddingFromBaselineVpY3zN4, 0.0f, 0.0f, f, 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 302366651, "C274@12065L6:Snackbar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m1068paddingqDBjuR0$default3 = PaddingKt.m1068paddingqDBjuR0$default(columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd()), 0.0f, 0.0f, function23 == null ? f : Dp.constructor-impl(0), 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 302366837, "C280@12251L501:Snackbar.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m4116setimpl(m4109constructorimpl4, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl4.getInserting() || !Intrinsics.areEqual(m4109constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 435596204, "C281@12273L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, i2 & 112);
            startRestartGroup.startReplaceableGroup(302367084);
            ComposerKt.sourceInformation(startRestartGroup, "287@12547L173");
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j2)), function23, startRestartGroup, ((i2 >> 3) & 112) | ProvidedValue.$stable | 0);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
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

                public final void invoke(Composer composer2, int i3) {
                    SnackbarKt.m2955NewLineButtonSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2956OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        float f;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)334@14108L3465,309@13126L4447:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? Fields.RenderEffect : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:305)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f2 = HorizontalSpacing;
            if (function23 == null) {
                f = HorizontalSpacingButtonSide;
            } else {
                f = Dp.constructor-impl(0);
            }
            Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(companion, f2, 0.0f, f, 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(44739392);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Snackbar.kt#9igjgp");
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            final String str = "text";
            final String str2 = "action";
            final String str3 = "dismissAction";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j3) {
                        float f3;
                        Measurable measurable;
                        Measurable measurable2;
                        int i3;
                        float f4;
                        int max;
                        final int i4;
                        final int height;
                        int i5;
                        float f5;
                        int i6 = Constraints.getMaxWidth-impl(j3);
                        f3 = SnackbarKt.ContainerMaxWidth;
                        int min = Math.min(i6, measureScope.roundToPx-0680j_4(f3));
                        String str4 = str2;
                        int size = list.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str4)) {
                                break;
                            }
                            i7++;
                        }
                        Measurable measurable3 = measurable;
                        Placeable mo6318measureBRTryo0 = measurable3 != null ? measurable3.mo6318measureBRTryo0(j3) : null;
                        String str5 = str3;
                        int size2 = list.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                measurable2 = null;
                                break;
                            }
                            measurable2 = list.get(i8);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str5)) {
                                break;
                            }
                            i8++;
                        }
                        Measurable measurable4 = measurable2;
                        final Placeable mo6318measureBRTryo02 = measurable4 != null ? measurable4.mo6318measureBRTryo0(j3) : null;
                        int width = mo6318measureBRTryo0 != null ? mo6318measureBRTryo0.getWidth() : 0;
                        int height2 = mo6318measureBRTryo0 != null ? mo6318measureBRTryo0.getHeight() : 0;
                        int width2 = mo6318measureBRTryo02 != null ? mo6318measureBRTryo02.getWidth() : 0;
                        int height3 = mo6318measureBRTryo02 != null ? mo6318measureBRTryo02.getHeight() : 0;
                        if (width2 == 0) {
                            f5 = SnackbarKt.TextEndExtraSpacing;
                            i3 = measureScope.roundToPx-0680j_4(f5);
                        } else {
                            i3 = 0;
                        }
                        int coerceAtLeast = RangesKt.coerceAtLeast(((min - width) - width2) - i3, Constraints.getMinWidth-impl(j3));
                        String str6 = str;
                        int size3 = list.size();
                        int i9 = 0;
                        while (i9 < size3) {
                            Measurable measurable5 = list.get(i9);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str6)) {
                                int i10 = height3;
                                final Placeable mo6318measureBRTryo03 = measurable5.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j3, 0, coerceAtLeast, 0, 0, 9, (Object) null));
                                int i11 = mo6318measureBRTryo03.get(androidx.compose.p002ui.layout.AlignmentLineKt.getFirstBaseline());
                                if (!(i11 != Integer.MIN_VALUE)) {
                                    throw new IllegalArgumentException("No baselines for text".toString());
                                }
                                int i12 = mo6318measureBRTryo03.get(androidx.compose.p002ui.layout.AlignmentLineKt.getLastBaseline());
                                if (!(i12 != Integer.MIN_VALUE)) {
                                    throw new IllegalArgumentException("No baselines for text".toString());
                                }
                                boolean z = i11 == i12;
                                final int i13 = min - width2;
                                final int i14 = i13 - width;
                                if (!z) {
                                    f4 = SnackbarKt.HeightToFirstLine;
                                    int i15 = measureScope.roundToPx-0680j_4(f4) - i11;
                                    max = Math.max(measureScope.roundToPx-0680j_4(SnackbarTokens.INSTANCE.m3901getTwoLinesContainerHeightD9Ej5fM()), mo6318measureBRTryo03.getHeight() + i15);
                                    i4 = i15;
                                    height = mo6318measureBRTryo0 != null ? (max - mo6318measureBRTryo0.getHeight()) / 2 : 0;
                                } else {
                                    int max2 = Math.max(measureScope.roundToPx-0680j_4(SnackbarTokens.INSTANCE.m3900getSingleLineContainerHeightD9Ej5fM()), Math.max(height2, i10));
                                    int height4 = (max2 - mo6318measureBRTryo03.getHeight()) / 2;
                                    height = (mo6318measureBRTryo0 == null || (i5 = mo6318measureBRTryo0.get(androidx.compose.p002ui.layout.AlignmentLineKt.getFirstBaseline())) == Integer.MIN_VALUE) ? 0 : (i11 + height4) - i5;
                                    i4 = height4;
                                    max = max2;
                                }
                                final int height5 = mo6318measureBRTryo02 != null ? (max - mo6318measureBRTryo02.getHeight()) / 2 : 0;
                                final Placeable placeable = mo6318measureBRTryo0;
                                return MeasureScope.layout$default(measureScope, min, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i4, 0.0f, 4, null);
                                        Placeable placeable2 = mo6318measureBRTryo02;
                                        if (placeable2 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i13, height5, 0.0f, 4, null);
                                        }
                                        Placeable placeable3 = placeable;
                                        if (placeable3 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i14, height, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                            i9++;
                            height3 = height3;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -167734359, "C311@13156L86:Snackbar.kt#uh7d8r");
            Modifier m1066paddingVpY3zN4$default = PaddingKt.m1066paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1066paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288408, "C311@13234L6:Snackbar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-167734260);
            ComposerKt.sourceInformation(startRestartGroup, "313@13293L295");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288523, "C314@13349L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, i2 & 112);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(44738899);
            ComposerKt.sourceInformation(startRestartGroup, "322@13660L247");
            if (function23 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "dismissAction");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId2);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288897, "C323@13723L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j2)), function23, startRestartGroup, ((i2 >> 3) & 112) | ProvidedValue.$stable | 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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

                public final void invoke(Composer composer2, int i3) {
                    SnackbarKt.m2956OneRowSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.constructor-impl(f);
        TextEndExtraSpacing = Dp.constructor-impl(f);
    }
}
