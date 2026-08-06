package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.Strings;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
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
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateRangePicker.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0087\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DateRangePickerHeadline-v84Udv0", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "DateRangePickerHeadline-0YIUgSQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerTitle", "DateRangePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    private DateRangePickerDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* renamed from: DateRangePickerTitle-hOD91z4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2504DateRangePickerTitlehOD91z4(final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1412719908);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerTitle)P(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
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
                    ComposerKt.traceEventStart(-1412719908, i5, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:339)");
                }
                if (!DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                    startRestartGroup.startReplaceableGroup(585816325);
                    ComposerKt.sourceInformation(startRestartGroup, "342@15160L48,341@15138L121");
                    Strings.Companion companion = Strings.INSTANCE;
                    TextKt.m3199Text4IGK_g(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_title), startRestartGroup, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, i5 & 112, 0, 131068);
                    startRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                    startRestartGroup.startReplaceableGroup(585816481);
                    ComposerKt.sourceInformation(startRestartGroup, "347@15316L47,346@15294L120");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    TextKt.m3199Text4IGK_g(Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_input_title), startRestartGroup, 0), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, i5 & 112, 0, 131068);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(585816611);
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
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1
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
                        DateRangePickerDefaults.this.m2504DateRangePickerTitlehOD91z4(i, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* renamed from: DateRangePickerHeadline-v84Udv0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2503DateRangePickerHeadlinev84Udv0(final Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1611069472);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerHeadline)P(4,3,1:c#material3.DisplayMode)373@16430L47,374@16504L45,375@16558L534:DateRangePicker.kt#uh7d8r");
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
            i4 |= startRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changed(i) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i4 |= (i2 & Fields.TransformOrigin) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? Fields.CameraDistance : Fields.RotationZ;
        }
        int i5 = i3 & 16;
        if (i5 != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? Fields.Clip : Fields.Shape;
            if ((i3 & 32) == 0) {
                i4 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i4 |= startRestartGroup.changed(this) ? Fields.RenderEffect : 65536;
            }
            if ((74899 & i4) == 74898 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1611069472, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:372)");
                }
                Strings.Companion companion = Strings.INSTANCE;
                final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
                Strings.Companion companion2 = Strings.INSTANCE;
                final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
                composer2 = startRestartGroup;
                m2501DateRangePickerHeadline0YIUgSQ(l, l2, i, datePickerFormatter, modifier4, m3033getStringNWtq28, m3033getStringNWtq282, ComposableLambdaKt.composableLambda(startRestartGroup, 482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
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
                        ComposerKt.sourceInformation(composer3, "C383@16939L26:DateRangePicker.kt#uh7d8r");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(482821121, i6, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:383)");
                        }
                        TextKt.m3199Text4IGK_g(m3033getStringNWtq28, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
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
                        ComposerKt.sourceInformation(composer3, "C384@17004L24:DateRangePicker.kt#uh7d8r");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1522669758, i6, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:384)");
                        }
                        TextKt.m3199Text4IGK_g(m3033getStringNWtq282, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), ComposableSingletons$DateRangePickerKt.INSTANCE.m2411getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), (i4 >> 15) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3
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
                        DateRangePickerDefaults.this.m2503DateRangePickerHeadlinev84Udv0(l, l2, i, datePickerFormatter, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i3 & 32) == 0) {
        }
        if ((74899 & i4) == 74898) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Strings.Companion companion3 = Strings.INSTANCE;
        final String m3033getStringNWtq283 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_start_headline), startRestartGroup, 0);
        Strings.Companion companion22 = Strings.INSTANCE;
        final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_range_picker_end_headline), startRestartGroup, 0);
        composer2 = startRestartGroup;
        m2501DateRangePickerHeadline0YIUgSQ(l, l2, i, datePickerFormatter, modifier4, m3033getStringNWtq283, m3033getStringNWtq2822, ComposableLambdaKt.composableLambda(startRestartGroup, 482821121, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1
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
                ComposerKt.sourceInformation(composer3, "C383@16939L26:DateRangePicker.kt#uh7d8r");
                if ((i6 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(482821121, i6, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:383)");
                }
                TextKt.m3199Text4IGK_g(m3033getStringNWtq283, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1522669758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2
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
                ComposerKt.sourceInformation(composer3, "C384@17004L24:DateRangePicker.kt#uh7d8r");
                if ((i6 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1522669758, i6, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:384)");
                }
                TextKt.m3199Text4IGK_g(m3033getStringNWtq2822, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), ComposableSingletons$DateRangePickerKt.INSTANCE.m2411getLambda1$material3_release(), startRestartGroup, (i4 & 14) | 918552576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), (i4 >> 15) & 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DateRangePickerHeadline-0YIUgSQ, reason: not valid java name */
    public final void m2501DateRangePickerHeadline0YIUgSQ(final Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, final Modifier modifier, final String str, final String str2, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i2, final int i3) {
        int i4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-820363420);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerHeadline)P(7,6,2:c#material3.DisplayMode!1,5,9,4,8,3)426@19095L15,461@20504L156,460@20446L720:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changed(i) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & Fields.TransformOrigin) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i4 |= startRestartGroup.changed(str) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= startRestartGroup.changed(str2) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
        }
        int i5 = i4;
        if ((306783379 & i5) != 306783378 || (i3 & 1) != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820363420, i5, i3, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:425)");
            }
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            String formatDate$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l, defaultLocale, false, 4, null);
            String formatDate$default2 = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, defaultLocale, false, 4, null);
            String formatDate = datePickerFormatter.formatDate(l, defaultLocale, true);
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(-1212631660);
            String str3 = "";
            ComposerKt.sourceInformation(composer2, "");
            if (formatDate == null) {
                if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                    composer2.startReplaceableGroup(-1212631439);
                    ComposerKt.sourceInformation(composer2, "442@19680L51");
                    Strings.Companion companion = Strings.INSTANCE;
                    formatDate = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_no_selection_description), composer2, 0);
                    composer2.endReplaceableGroup();
                } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                    composer2.startReplaceableGroup(-1212631354);
                    ComposerKt.sourceInformation(composer2, "443@19765L46");
                    Strings.Companion companion2 = Strings.INSTANCE;
                    formatDate = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_no_input_description), composer2, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(1063135767);
                    composer2.endReplaceableGroup();
                    formatDate = "";
                }
            }
            composer2.endReplaceableGroup();
            String formatDate2 = datePickerFormatter.formatDate(l2, defaultLocale, true);
            composer2.startReplaceableGroup(-1212631233);
            ComposerKt.sourceInformation(composer2, "");
            if (formatDate2 != null) {
                str3 = formatDate2;
            } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2537getPickerjFl4v0())) {
                composer2.startReplaceableGroup(-1212631014);
                ComposerKt.sourceInformation(composer2, "452@20105L51");
                Strings.Companion companion3 = Strings.INSTANCE;
                str3 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_picker_no_selection_description), composer2, 0);
                composer2.endReplaceableGroup();
            } else if (DisplayMode.m2532equalsimpl0(i, DisplayMode.INSTANCE.m2536getInputjFl4v0())) {
                composer2.startReplaceableGroup(-1212630929);
                ComposerKt.sourceInformation(composer2, "453@20190L46");
                Strings.Companion companion4 = Strings.INSTANCE;
                str3 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_no_input_description), composer2, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1063148942);
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            final String str4 = str + ": " + formatDate;
            final String str5 = str2 + ": " + str3;
            composer2.startReplaceableGroup(-1212630615);
            ComposerKt.sourceInformation(composer2, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = composer2.changed(str4) | composer2.changed(str5);
            Object rememberedValue = composer2.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$4$1
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
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4 + ", " + str5);
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceableGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) rememberedValue);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m909spacedBy0680j_4 = Arrangement.INSTANCE.m909spacedBy0680j_4(Dp.constructor-impl(4));
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m909spacedBy0680j_4, centerVertically, composer2, 54);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1922100092, "C473@20978L16:DateRangePicker.kt#uh7d8r");
            if (formatDate$default != null) {
                composer2.startReplaceableGroup(1922100124);
                ComposerKt.sourceInformation(composer2, "469@20860L31");
                TextKt.m3199Text4IGK_g(formatDate$default, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1922100193);
                ComposerKt.sourceInformation(composer2, "471@20929L22");
                function2.invoke(composer2, Integer.valueOf((i5 >> 21) & 14));
                composer2.endReplaceableGroup();
            }
            function23.invoke(composer2, Integer.valueOf((i5 >> 27) & 14));
            if (formatDate$default2 != null) {
                composer2.startReplaceableGroup(1922100319);
                ComposerKt.sourceInformation(composer2, "475@21055L29");
                TextKt.m3199Text4IGK_g(formatDate$default2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1922100386);
                ComposerKt.sourceInformation(composer2, "477@21122L20");
                function22.invoke(composer2, Integer.valueOf((i5 >> 24) & 14));
                composer2.endReplaceableGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$6
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

                public final void invoke(Composer composer3, int i6) {
                    DateRangePickerDefaults.this.m2501DateRangePickerHeadline0YIUgSQ(l, l2, i, datePickerFormatter, modifier, str, str2, function2, function22, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }
}
