package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(J$\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010-J\u008e\u0002\u0010,\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u00020/2\b\b\u0002\u00104\u001a\u00020/2\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020/2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ$\u0010#\u001a\u00020$2\b\b\u0002\u0010K\u001a\u00020\r2\b\b\u0002\u0010L\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020\rJ'\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020T0SH\u0001¢\u0006\u0004\bU\u0010VR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "DatePickerHeadline", "", "selectedDateMillis", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DatePickerHeadline-3kbWawI", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "DatePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "yearSelectionSkeleton", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final IntRange YearRange = new IntRange(1900, 2100);
    private static final float TonalElevation = DatePickerModalTokens.INSTANCE.m3539getContainerElevationD9Ej5fM();
    private static final SelectableDates AllDates = new SelectableDates() { // from class: androidx.compose.material3.DatePickerDefaults$AllDates$1
    };

    private DatePickerDefaults() {
    }

    public final DatePickerColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-275219611);
        ComposerKt.sourceInformation(composer, "C(colors)433@17872L11,433@17884L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, i, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:433)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultDatePickerColors;
    }

    /* renamed from: colors-bSRYm20, reason: not valid java name */
    public final DatePickerColors m2469colorsbSRYm20(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, Composer composer, int i, int i2, int i3, int i4) {
        composer.startReplaceableGroup(1991626358);
        ComposerKt.sourceInformation(composer, "C(colors)P(0:c#ui.graphics.Color,20:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,19:c#ui.graphics.Color,14:c#ui.graphics.Color,24:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,18:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,21:c#ui.graphics.Color,22:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color)502@22150L11,502@22162L23:DatePicker.kt#uh7d8r");
        long m4875getUnspecified0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
        long m4875getUnspecified0d7_KjU2 = (i4 & 2) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j2;
        long m4875getUnspecified0d7_KjU3 = (i4 & 4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j3;
        long m4875getUnspecified0d7_KjU4 = (i4 & 8) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j4;
        long m4875getUnspecified0d7_KjU5 = (i4 & 16) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j5;
        long m4875getUnspecified0d7_KjU6 = (i4 & 32) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j6;
        long m4875getUnspecified0d7_KjU7 = (i4 & 64) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j7;
        long m4875getUnspecified0d7_KjU8 = (i4 & Fields.SpotShadowColor) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j8;
        long m4875getUnspecified0d7_KjU9 = (i4 & Fields.RotationX) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j9;
        long m4875getUnspecified0d7_KjU10 = (i4 & Fields.RotationY) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j10;
        long m4875getUnspecified0d7_KjU11 = (i4 & Fields.RotationZ) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j11;
        long m4875getUnspecified0d7_KjU12 = (i4 & Fields.CameraDistance) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j12;
        long m4875getUnspecified0d7_KjU13 = (i4 & Fields.TransformOrigin) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j13;
        long m4875getUnspecified0d7_KjU14 = (i4 & Fields.Shape) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j14;
        long m4875getUnspecified0d7_KjU15 = (i4 & Fields.Clip) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j15;
        long m4875getUnspecified0d7_KjU16 = (32768 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j16;
        long m4875getUnspecified0d7_KjU17 = (65536 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j17;
        long m4875getUnspecified0d7_KjU18 = (131072 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j18;
        long m4875getUnspecified0d7_KjU19 = (262144 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j19;
        long m4875getUnspecified0d7_KjU20 = (524288 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j20;
        long m4875getUnspecified0d7_KjU21 = (1048576 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j21;
        long m4875getUnspecified0d7_KjU22 = (2097152 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j22;
        long m4875getUnspecified0d7_KjU23 = (4194304 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j23;
        long m4875getUnspecified0d7_KjU24 = (8388608 & i4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j24;
        TextFieldColors textFieldColors2 = (i4 & 16777216) != 0 ? null : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991626358, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:502)");
        }
        DatePickerColors m2441copytNwlRmA = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i3 >> 12) & 112).m2441copytNwlRmA(m4875getUnspecified0d7_KjU, m4875getUnspecified0d7_KjU2, m4875getUnspecified0d7_KjU3, m4875getUnspecified0d7_KjU4, m4875getUnspecified0d7_KjU5, m4875getUnspecified0d7_KjU6, m4875getUnspecified0d7_KjU7, m4875getUnspecified0d7_KjU8, m4875getUnspecified0d7_KjU9, m4875getUnspecified0d7_KjU10, m4875getUnspecified0d7_KjU11, m4875getUnspecified0d7_KjU12, m4875getUnspecified0d7_KjU13, m4875getUnspecified0d7_KjU14, m4875getUnspecified0d7_KjU15, m4875getUnspecified0d7_KjU16, m4875getUnspecified0d7_KjU17, m4875getUnspecified0d7_KjU18, m4875getUnspecified0d7_KjU19, m4875getUnspecified0d7_KjU20, m4875getUnspecified0d7_KjU21, m4875getUnspecified0d7_KjU23, m4875getUnspecified0d7_KjU22, m4875getUnspecified0d7_KjU24, textFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2441copytNwlRmA;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme colorScheme, Composer composer, int i) {
        composer.startReplaceableGroup(1180555308);
        ComposerKt.sourceInformation(composer, "C*581@27175L30:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:532)");
        }
        DatePickerColors defaultDatePickerColorsCached = colorScheme.getDefaultDatePickerColorsCached();
        if (defaultDatePickerColorsCached == null) {
            defaultDatePickerColorsCached = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), colorScheme.getOnSurfaceVariant(), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme, composer, (i & 14) | 48), null);
            colorScheme.setDefaultDatePickerColorsCached$material3_release(defaultDatePickerColorsCached);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultDatePickerColorsCached;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    public final DatePickerFormatter dateFormatter(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        return new DatePickerFormatterImpl(yearSelectionSkeleton, selectedDateSkeleton, selectedDateDescriptionSkeleton);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* renamed from: DatePickerTitle-hOD91z4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2468DatePickerTitlehOD91z4(final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(327413563);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerTitle)P(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(i) ? 4 : 2);
        } else {
            i4 = i2;
        }
        int i6 = i3 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i5 = i4;
            if ((i5 & 19) == 18 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(327413563, i5, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:621)");
                }
                if (!DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                    startRestartGroup.startReplaceableGroup(-2065101749);
                    ComposerKt.sourceInformation(startRestartGroup, "624@29127L43,623@29098L123");
                    Strings.Companion companion = Strings.INSTANCE;
                    TextKt.m3199Text4IGK_g(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_title), startRestartGroup, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, i5 & 112, 0, 131068);
                    startRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                    startRestartGroup.startReplaceableGroup(-2065101591);
                    ComposerKt.sourceInformation(startRestartGroup, "629@29285L42,628@29256L122");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    TextKt.m3199Text4IGK_g(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_title), startRestartGroup, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, i5 & 112, 0, 131068);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-2065101459);
                    startRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1
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
                        DatePickerDefaults.this.m2468DatePickerTitlehOD91z4(i, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        i5 = i4;
        if ((i5 & 19) == 18) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009c  */
    /* renamed from: DatePickerHeadline-3kbWawI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2467DatePickerHeadline3kbWawI(final Long l, final int i, final DatePickerFormatter datePickerFormatter, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        String formatDate$default;
        String formatDate;
        boolean changed;
        Object rememberedValue;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1502835813);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerHeadline)P(3,1:c#material3.DisplayMode)652@30155L15,681@31348L123,679@31267L240:DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= (i2 & Fields.RotationY) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i5 = i3 & 8;
        if (i5 != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.CameraDistance : Fields.RotationZ;
            if ((i4 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1502835813, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:651)");
                }
                Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                formatDate$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l, defaultLocale, false, 4, null);
                formatDate = datePickerFormatter.formatDate(l, defaultLocale, true);
                startRestartGroup.startReplaceableGroup(729793187);
                String str = "";
                ComposerKt.sourceInformation(startRestartGroup, "");
                if (formatDate == null) {
                    if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                        startRestartGroup.startReplaceableGroup(729793403);
                        ComposerKt.sourceInformation(startRestartGroup, "662@30568L51");
                        Strings.Companion companion = Strings.INSTANCE;
                        formatDate = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_no_selection_description), startRestartGroup, 0);
                        startRestartGroup.endReplaceableGroup();
                    } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                        startRestartGroup.startReplaceableGroup(729793488);
                        ComposerKt.sourceInformation(startRestartGroup, "663@30653L46");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        formatDate = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_no_input_description), startRestartGroup, 0);
                        startRestartGroup.endReplaceableGroup();
                    } else {
                        startRestartGroup.startReplaceableGroup(1148763725);
                        startRestartGroup.endReplaceableGroup();
                        formatDate = "";
                    }
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(729793596);
                ComposerKt.sourceInformation(startRestartGroup, "");
                if (formatDate$default == null) {
                    if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                        startRestartGroup.startReplaceableGroup(729793668);
                        ComposerKt.sourceInformation(startRestartGroup, "668@30833L37");
                        Strings.Companion companion3 = Strings.INSTANCE;
                        formatDate$default = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_headline), startRestartGroup, 0);
                        startRestartGroup.endReplaceableGroup();
                    } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                        startRestartGroup.startReplaceableGroup(729793739);
                        ComposerKt.sourceInformation(startRestartGroup, "669@30904L36");
                        Strings.Companion companion4 = Strings.INSTANCE;
                        formatDate$default = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_headline), startRestartGroup, 0);
                        startRestartGroup.endReplaceableGroup();
                    } else {
                        startRestartGroup.startReplaceableGroup(1148771196);
                        startRestartGroup.endReplaceableGroup();
                        formatDate$default = "";
                    }
                }
                startRestartGroup.endReplaceableGroup();
                if (!DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                    startRestartGroup.startReplaceableGroup(729793899);
                    ComposerKt.sourceInformation(startRestartGroup, "674@31064L48");
                    Strings.Companion companion5 = Strings.INSTANCE;
                    str = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_headline_description), startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                    startRestartGroup.startReplaceableGroup(729793981);
                    ComposerKt.sourceInformation(startRestartGroup, "675@31146L47");
                    Strings.Companion companion6 = Strings.INSTANCE;
                    str = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_headline_description), startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(1148779039);
                    startRestartGroup.endReplaceableGroup();
                }
                final String format = String.format(str, Arrays.copyOf(new Object[]{formatDate}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                startRestartGroup.startReplaceableGroup(729794183);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                changed = startRestartGroup.changed(format);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1
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
                            SemanticsPropertiesKt.setLiveRegion-hR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.getPolite-0phEisY());
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, format);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier modifier5 = modifier4;
                composer2 = startRestartGroup;
                TextKt.m3199Text4IGK_g(formatDate$default, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 3072, 122876);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        DatePickerDefaults.this.m2467DatePickerHeadline3kbWawI(l, i, datePickerFormatter, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i4 & 1171) == 1170) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Locale defaultLocale2 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
        formatDate$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l, defaultLocale2, false, 4, null);
        formatDate = datePickerFormatter.formatDate(l, defaultLocale2, true);
        startRestartGroup.startReplaceableGroup(729793187);
        String str2 = "";
        ComposerKt.sourceInformation(startRestartGroup, "");
        if (formatDate == null) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(729793596);
        ComposerKt.sourceInformation(startRestartGroup, "");
        if (formatDate$default == null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (!DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
        }
        final String format2 = String.format(str2, Arrays.copyOf(new Object[]{formatDate}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        startRestartGroup.startReplaceableGroup(729794183);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
        changed = startRestartGroup.changed(format2);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1
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
                SemanticsPropertiesKt.setLiveRegion-hR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.getPolite-0phEisY());
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, format2);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        Modifier modifier52 = modifier4;
        composer2 = startRestartGroup;
        TextKt.m3199Text4IGK_g(formatDate$default, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 3072, 122876);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier52;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-2036003494);
        ComposerKt.sourceInformation(composer, "C(rememberSnapFlingBehavior)P(1)701@32015L7,702@32038L295:DatePicker.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:700)");
        }
        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        composer.startReplaceableGroup(-1872611444);
        ComposerKt.sourceInformation(composer, "CC(remember):DatePicker.kt#9igjgp");
        boolean changed = composer.changed(density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SnapFlingBehavior(lazyListState, decayAnimationSpec, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), density);
            composer.updateRememberedValue(rememberedValue);
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2470getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(700927667);
        ComposerKt.sourceInformation(composer, "C719@32723L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:719)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }
}
