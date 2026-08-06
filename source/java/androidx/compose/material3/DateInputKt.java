package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.Strings;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001ad\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u0098\u0001\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010 ¢\u0006\u0002\b!2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010 ¢\u0006\u0002\b!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\n\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006.²\u0006\n\u0010/\u001a\u000200X\u008a\u008e\u0002"}, d2 = {"InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-tQNruF0", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "material3_release", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding = Dp.constructor-impl(16);

    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v5 */
    public static final void DateInputContent(final Long l, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Locale locale;
        DateInputFormat dateInputFormat;
        int i3;
        ?? r13;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(643325609);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputContent)P(5,3!1,6,2,4)57@2329L15,58@2371L87,61@2486L45,62@2566L44,63@2644L45,64@2719L507,77@3315L42,78@3362L891:DateInput.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & Fields.CompositingStrategy) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 16384 : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 1048576 : Fields.BlendMode;
        }
        int i4 = i2;
        if ((599187 & i4) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643325609, i4, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:55)");
            }
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-356766397);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateInput.kt#9igjgp");
            boolean changed = startRestartGroup.changed(defaultLocale);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = calendarModel.getDateInputFormat(defaultLocale);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            DateInputFormat dateInputFormat2 = (DateInputFormat) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Strings.Companion companion = Strings.INSTANCE;
            String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_invalid_for_pattern), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_invalid_year_range), startRestartGroup, 0);
            Strings.Companion companion3 = Strings.INSTANCE;
            String m3033getStringNWtq283 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_invalid_not_allowed), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-356766049);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateInput.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(dateInputFormat2) | ((57344 & i4) == 16384 || ((32768 & i4) != 0 && startRestartGroup.changed(datePickerFormatter)));
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                locale = defaultLocale;
                dateInputFormat = dateInputFormat2;
                i3 = i4;
                r13 = 1;
                DateInputValidator dateInputValidator = new DateInputValidator(intRange, selectableDates, dateInputFormat2, datePickerFormatter, m3033getStringNWtq28, m3033getStringNWtq282, m3033getStringNWtq283, "", null, null, 768, null);
                composer2 = startRestartGroup;
                composer2.updateRememberedValue(dateInputValidator);
                rememberedValue2 = dateInputValidator;
            } else {
                locale = defaultLocale;
                dateInputFormat = dateInputFormat2;
                i3 = i4;
                r13 = 1;
                composer2 = startRestartGroup;
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) rememberedValue2;
            composer2.endReplaceableGroup();
            final String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            Strings.Companion companion4 = Strings.INSTANCE;
            final String m3033getStringNWtq284 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_date_input_label), composer2, 0);
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, r13, null), InputTextFieldPadding);
            int m2644getSingleDateInputJ2x2o4M = InputIdentifier.INSTANCE.m2644getSingleDateInputJ2x2o4M();
            dateInputValidator2.setCurrentStartDateMillis$material3_release(l);
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -1819015125, r13, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i5) {
                    ComposerKt.sourceInformation(composer4, "C86@3631L47,84@3552L127:DateInput.kt#uh7d8r");
                    if ((i5 & 3) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1819015125, i5, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:84)");
                    }
                    String str = m3033getStringNWtq284;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    composer4.startReplaceableGroup(-694340528);
                    ComposerKt.sourceInformation(composer4, "CC(remember):DateInput.kt#9igjgp");
                    boolean changed3 = composer4.changed(m3033getStringNWtq284) | composer4.changed(upperCase);
                    final String str2 = m3033getStringNWtq284;
                    final String str3 = upperCase;
                    Object rememberedValue3 = composer4.rememberedValue();
                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$2$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str2 + ", " + str3);
                            }
                        };
                        composer4.updateRememberedValue(rememberedValue3);
                    }
                    composer4.endReplaceableGroup();
                    TextKt.m3199Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion5, false, (Function1) rememberedValue3, 1, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -564233108, r13, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i5) {
                    ComposerKt.sourceInformation(composer4, "C88@3715L59:DateInput.kt#uh7d8r");
                    if ((i5 & 3) == 2 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-564233108, i5, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:88)");
                    }
                    TextKt.m3199Text4IGK_g(upperCase, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$3.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }
                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            int i5 = i3 << 3;
            composer3 = composer2;
            m2436DateInputTextFieldtQNruF0(padding, l, function1, calendarModel, composableLambda, composableLambda2, m2644getSingleDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, locale, datePickerColors, composer2, (i5 & 112) | 1794054 | (i5 & 896) | (i5 & 7168), (i3 >> 18) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$4
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

                public final void invoke(Composer composer4, int i6) {
                    DateInputKt.DateInputContent(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x017a, code lost:
    
        if (r9 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L105;
     */
    /* renamed from: DateInputTextField-tQNruF0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2436DateInputTextFieldtQNruF0(final Modifier modifier, final Long l, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final DateInputValidator dateInputValidator, final DateInputFormat dateInputFormat, final Locale locale, final DatePickerColors datePickerColors, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Object obj;
        String str;
        Object obj2;
        float f;
        Composer startRestartGroup = composer.startRestartGroup(-857008589);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateInputTextField)P(8,4,9!1,6,10,5:c#material3.InputIdentifier,3,2,7)117@4757L39,118@4865L388,118@4813L440,135@5324L1418,178@7156L88,133@5259L2503:DateInput.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(l) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(calendarModel) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= startRestartGroup.changed(i) ? 1048576 : Fields.BlendMode;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= startRestartGroup.changed(dateInputValidator) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= startRestartGroup.changed(dateInputFormat) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= startRestartGroup.changedInstance(locale) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) != 306783378 || (i5 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-857008589, i4, i5, "androidx.compose.material3.DateInputTextField (DateInput.kt:116)");
            }
            int i6 = i4;
            final MutableState mutableState = (MutableState) RememberSaveableKt.m4241rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<String>>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$errorText$1
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MutableState<String> m2437invoke() {
                    MutableState<String> mutableStateOf$default;
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    return mutableStateOf$default;
                }
            }, startRestartGroup, 3072, 6);
            Object[] objArr = new Object[0];
            Saver saver = TextFieldValue.Companion.getSaver();
            startRestartGroup.startReplaceableGroup(1947288557);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateInput.kt#9igjgp");
            int i7 = 234881024 & i6;
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(calendarModel) | (i7 == 67108864) | startRestartGroup.changedInstance(locale);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
                obj = rememberedValue;
            }
            Function0<MutableState<TextFieldValue>> function0 = new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$text$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
                
                    if (r0 == null) goto L6;
                 */
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final MutableState<TextFieldValue> m2438invoke() {
                    String str2;
                    MutableState<TextFieldValue> mutableStateOf$default;
                    Long l2 = l;
                    if (l2 != null) {
                        CalendarModel calendarModel2 = calendarModel;
                        DateInputFormat dateInputFormat2 = dateInputFormat;
                        str2 = calendarModel2.formatWithPattern(l2.longValue(), dateInputFormat2.getPatternWithoutDelimiters(), locale);
                    }
                    str2 = "";
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, TextRangeKt.TextRange(0, 0), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                    return mutableStateOf$default;
                }
            };
            startRestartGroup.updateRememberedValue(function0);
            obj = function0;
            startRestartGroup.endReplaceableGroup();
            final MutableState rememberSaveable = RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, (Function0) obj, startRestartGroup, 0, 4);
            TextFieldValue DateInputTextField_tQNruF0$lambda$4 = DateInputTextField_tQNruF0$lambda$4(rememberSaveable);
            startRestartGroup.startReplaceableGroup(1947289016);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateInput.kt#9igjgp");
            boolean changed = (i7 == 67108864) | startRestartGroup.changed(rememberSaveable) | startRestartGroup.changed(mutableState) | ((i6 & 896) == 256) | startRestartGroup.changedInstance(calendarModel) | ((i6 & 29360128) == 8388608) | ((i6 & 3670016) == 1048576) | startRestartGroup.changedInstance(locale);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):DateInput.kt#9igjgp";
                Function1<TextFieldValue, Unit> function12 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                        invoke((TextFieldValue) obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(TextFieldValue textFieldValue) {
                        boolean z;
                        if (textFieldValue.getText().length() <= DateInputFormat.this.getPatternWithoutDelimiters().length()) {
                            String text = textFieldValue.getText();
                            int i8 = 0;
                            while (true) {
                                if (i8 >= text.length()) {
                                    z = true;
                                    break;
                                } else {
                                    if (!Character.isDigit(text.charAt(i8))) {
                                        z = false;
                                        break;
                                    }
                                    i8++;
                                }
                            }
                            if (z) {
                                rememberSaveable.setValue(textFieldValue);
                                String obj3 = StringsKt.trim(textFieldValue.getText()).toString();
                                Long l2 = null;
                                if ((obj3.length() == 0) || obj3.length() < DateInputFormat.this.getPatternWithoutDelimiters().length()) {
                                    mutableState.setValue("");
                                    function1.invoke((Object) null);
                                    return;
                                }
                                CalendarDate parse = calendarModel.parse(obj3, DateInputFormat.this.getPatternWithoutDelimiters());
                                mutableState.setValue(dateInputValidator.m2439validateXivgLIo(parse, i, locale));
                                Function1<Long, Unit> function13 = function1;
                                if ((mutableState.getValue().length() == 0) && parse != null) {
                                    l2 = Long.valueOf(parse.getUtcTimeMillis());
                                }
                                function13.invoke(l2);
                            }
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(function12);
                obj2 = function12;
            } else {
                str = "CC(remember):DateInput.kt#9igjgp";
                obj2 = rememberedValue2;
            }
            Function1 function13 = (Function1) obj2;
            startRestartGroup.endReplaceableGroup();
            if (!(!StringsKt.isBlank((CharSequence) mutableState.getValue()))) {
                f = InputTextNonErroneousBottomPadding;
            } else {
                f = Dp.constructor-impl(0);
            }
            Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f, 7, null);
            startRestartGroup.startReplaceableGroup(1947290848);
            ComposerKt.sourceInformation(startRestartGroup, str);
            boolean changed2 = startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$2$1
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
                        if (!StringsKt.isBlank(mutableState.getValue())) {
                            SemanticsPropertiesKt.error(semanticsPropertyReceiver, mutableState.getValue());
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            int i8 = i6 << 6;
            OutlinedTextFieldKt.OutlinedTextField(DateInputTextField_tQNruF0$lambda$4, (Function1<? super TextFieldValue, Unit>) function13, SemanticsModifierKt.semantics$default(m1068paddingqDBjuR0$default, false, (Function1) rememberedValue3, 1, (Object) null), false, false, (TextStyle) null, function2, function22, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -591991974, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    ComposerKt.sourceInformation(composer2, "C183@7365L21:DateInput.kt#uh7d8r");
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-591991974, i9, -1, "androidx.compose.material3.DateInputTextField.<anonymous> (DateInput.kt:183)");
                    }
                    if (!StringsKt.isBlank(mutableState.getValue())) {
                        TextKt.m3199Text4IGK_g(mutableState.getValue(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 0, 0, 131070);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), !StringsKt.isBlank((CharSequence) mutableState.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat), new KeyboardOptions(0, false, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), (PlatformImeOptions) null, 17, (DefaultConstructorMarker) null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, datePickerColors.getDateTextFieldColors(), startRestartGroup, (i8 & 3670016) | (i8 & 29360128), 12779904, 0, 4001592);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    DateInputKt.m2436DateInputTextFieldtQNruF0(Modifier.this, l, function1, calendarModel, function2, function22, i, dateInputValidator, dateInputFormat, locale, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    private static final TextFieldValue DateInputTextField_tQNruF0$lambda$4(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }

    static {
        float f = 24;
        InputTextFieldPadding = PaddingKt.m1061PaddingValuesa9UjIt4$default(Dp.constructor-impl(f), Dp.constructor-impl(10), Dp.constructor-impl(f), 0.0f, 8, null);
    }
}
