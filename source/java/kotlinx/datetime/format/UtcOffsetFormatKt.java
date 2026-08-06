package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.openid.appauth.BuildConfig;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(m4d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0000¢\u0006\u0002\u0010\t\u001a,\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\"\u001b\u0010\u0011\u001a\u00020\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\"\u001b\u0010\u0017\u001a\u00020\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014\"\u001b\u0010\u001a\u001a\u00020\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014\"\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5d2 = {"outputIfNeeded", BuildConfig.FLAVOR, "T", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "whenToOutput", "Lkotlinx/datetime/format/WhenToOutput;", "format", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/datetime/format/DateTimeFormatBuilder;Lkotlinx/datetime/format/WhenToOutput;Lkotlin/jvm/functions/Function1;)V", "isoOffset", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "zOnZero", BuildConfig.FLAVOR, "useSeparator", "outputMinute", "outputSecond", "ISO_OFFSET", "Lkotlinx/datetime/format/UtcOffsetFormat;", "getISO_OFFSET", "()Lkotlinx/datetime/format/UtcOffsetFormat;", "ISO_OFFSET$delegate", "Lkotlin/Lazy;", "ISO_OFFSET_BASIC", "getISO_OFFSET_BASIC", "ISO_OFFSET_BASIC$delegate", "FOUR_DIGIT_OFFSET", "getFOUR_DIGIT_OFFSET", "FOUR_DIGIT_OFFSET$delegate", "emptyIncompleteUtcOffset", "Lkotlinx/datetime/format/IncompleteUtcOffset;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UtcOffsetFormatKt {
    private static final Lazy ISO_OFFSET$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UtcOffsetFormat ISO_OFFSET_delegate$lambda$12;
            ISO_OFFSET_delegate$lambda$12 = UtcOffsetFormatKt.ISO_OFFSET_delegate$lambda$12();
            return ISO_OFFSET_delegate$lambda$12;
        }
    });
    private static final Lazy ISO_OFFSET_BASIC$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UtcOffsetFormat ISO_OFFSET_BASIC_delegate$lambda$19;
            ISO_OFFSET_BASIC_delegate$lambda$19 = UtcOffsetFormatKt.ISO_OFFSET_BASIC_delegate$lambda$19();
            return ISO_OFFSET_BASIC_delegate$lambda$19;
        }
    });
    private static final Lazy FOUR_DIGIT_OFFSET$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UtcOffsetFormat FOUR_DIGIT_OFFSET_delegate$lambda$21;
            FOUR_DIGIT_OFFSET_delegate$lambda$21 = UtcOffsetFormatKt.FOUR_DIGIT_OFFSET_delegate$lambda$21();
            return FOUR_DIGIT_OFFSET_delegate$lambda$21;
        }
    });
    private static final IncompleteUtcOffset emptyIncompleteUtcOffset = new IncompleteUtcOffset(null, null, null, null, 15, null);

    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WhenToOutput.values().length];
            try {
                iArr[WhenToOutput.NEVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WhenToOutput.IF_NONZERO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WhenToOutput.ALWAYS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T extends DateTimeFormatBuilder> void outputIfNeeded(T t, WhenToOutput whenToOutput, final Function1<? super T, Unit> format) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(whenToOutput, "whenToOutput");
        Intrinsics.checkNotNullParameter(format, "format");
        int i = WhenMappings.$EnumSwitchMapping$0[whenToOutput.ordinal()];
        if (i != 1) {
            if (i == 2) {
                DateTimeFormatBuilderKt.optional$default(t, null, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit outputIfNeeded$lambda$0;
                        outputIfNeeded$lambda$0 = UtcOffsetFormatKt.outputIfNeeded$lambda$0(Function1.this, (DateTimeFormatBuilder) obj);
                        return outputIfNeeded$lambda$0;
                    }
                }, 1, null);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                format.invoke(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit outputIfNeeded$lambda$0(Function1 format, DateTimeFormatBuilder optional) {
        Intrinsics.checkNotNullParameter(format, "$format");
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        format.invoke(optional);
        return Unit.INSTANCE;
    }

    public static final void isoOffset(DateTimeFormatBuilder.WithUtcOffset withUtcOffset, boolean z, final boolean z2, final WhenToOutput outputMinute, final WhenToOutput outputSecond) {
        Intrinsics.checkNotNullParameter(withUtcOffset, "<this>");
        Intrinsics.checkNotNullParameter(outputMinute, "outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "outputSecond");
        if (!(outputMinute.compareTo(outputSecond) >= 0)) {
            throw new IllegalArgumentException("Seconds cannot be included without minutes".toString());
        }
        if (z) {
            DateTimeFormatBuilderKt.optional(withUtcOffset, "Z", new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit isoOffset$lambda$6;
                    isoOffset$lambda$6 = UtcOffsetFormatKt.isoOffset$lambda$6(WhenToOutput.this, z2, outputSecond, (DateTimeFormatBuilder.WithUtcOffset) obj);
                    return isoOffset$lambda$6;
                }
            });
        } else {
            isoOffset$appendIsoOffsetWithoutZOnZero(withUtcOffset, outputMinute, z2, outputSecond);
        }
    }

    private static final void isoOffset$appendIsoOffsetWithoutZOnZero(DateTimeFormatBuilder.WithUtcOffset withUtcOffset, WhenToOutput whenToOutput, final boolean z, final WhenToOutput whenToOutput2) {
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(withUtcOffset, null, 1, null);
        outputIfNeeded(withUtcOffset, whenToOutput, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3;
                isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3 = UtcOffsetFormatKt.isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3(z, whenToOutput2, (DateTimeFormatBuilder.WithUtcOffset) obj);
                return isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3(final boolean z, WhenToOutput outputSecond, DateTimeFormatBuilder.WithUtcOffset outputIfNeeded) {
        Intrinsics.checkNotNullParameter(outputSecond, "$outputSecond");
        Intrinsics.checkNotNullParameter(outputIfNeeded, "$this$outputIfNeeded");
        if (z) {
            DateTimeFormatBuilderKt.m1967char(outputIfNeeded, AbstractJsonLexerKt.COLON);
        }
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(outputIfNeeded, null, 1, null);
        outputIfNeeded(outputIfNeeded, outputSecond, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3$lambda$2;
                isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3$lambda$2 = UtcOffsetFormatKt.isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3$lambda$2(z, (DateTimeFormatBuilder.WithUtcOffset) obj);
                return isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3$lambda$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isoOffset$appendIsoOffsetWithoutZOnZero$lambda$3$lambda$2(boolean z, DateTimeFormatBuilder.WithUtcOffset outputIfNeeded) {
        Intrinsics.checkNotNullParameter(outputIfNeeded, "$this$outputIfNeeded");
        if (z) {
            DateTimeFormatBuilderKt.m1967char(outputIfNeeded, AbstractJsonLexerKt.COLON);
        }
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetSecondsOfMinute$default(outputIfNeeded, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isoOffset$lambda$6(final WhenToOutput outputMinute, final boolean z, final WhenToOutput outputSecond, DateTimeFormatBuilder.WithUtcOffset optional) {
        Intrinsics.checkNotNullParameter(outputMinute, "$outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "$outputSecond");
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilderKt.alternativeParsing(optional, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit isoOffset$lambda$6$lambda$4;
                isoOffset$lambda$6$lambda$4 = UtcOffsetFormatKt.isoOffset$lambda$6$lambda$4((DateTimeFormatBuilder.WithUtcOffset) obj);
                return isoOffset$lambda$6$lambda$4;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit isoOffset$lambda$6$lambda$5;
                isoOffset$lambda$6$lambda$5 = UtcOffsetFormatKt.isoOffset$lambda$6$lambda$5(WhenToOutput.this, z, outputSecond, (DateTimeFormatBuilder.WithUtcOffset) obj);
                return isoOffset$lambda$6$lambda$5;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isoOffset$lambda$6$lambda$4(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.m1967char(alternativeParsing, 'z');
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isoOffset$lambda$6$lambda$5(WhenToOutput outputMinute, boolean z, WhenToOutput outputSecond, DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
        Intrinsics.checkNotNullParameter(outputMinute, "$outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "$outputSecond");
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        isoOffset$appendIsoOffsetWithoutZOnZero(alternativeParsing, outputMinute, z, outputSecond);
        return Unit.INSTANCE;
    }

    public static final UtcOffsetFormat getISO_OFFSET() {
        return (UtcOffsetFormat) ISO_OFFSET$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UtcOffsetFormat ISO_OFFSET_delegate$lambda$12() {
        return UtcOffsetFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_delegate$lambda$12$lambda$11;
                ISO_OFFSET_delegate$lambda$12$lambda$11 = UtcOffsetFormatKt.ISO_OFFSET_delegate$lambda$12$lambda$11((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_delegate$lambda$12$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_delegate$lambda$12$lambda$11(DateTimeFormatBuilder.WithUtcOffset build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilderKt.alternativeParsing(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$7;
                ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$7 = UtcOffsetFormatKt.ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$7((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$7;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10;
                ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10 = UtcOffsetFormatKt.ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$7(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        alternativeParsing.chars("z");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.optional(alternativeParsing, "Z", new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10$lambda$9;
                ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10$lambda$9 = UtcOffsetFormatKt.ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10$lambda$9((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10$lambda$9;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10$lambda$9(DateTimeFormatBuilder.WithUtcOffset optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(optional, null, 1, null);
        DateTimeFormatBuilder.WithUtcOffset withUtcOffset = optional;
        DateTimeFormatBuilderKt.m1967char(withUtcOffset, AbstractJsonLexerKt.COLON);
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(optional, null, 1, null);
        DateTimeFormatBuilderKt.optional$default(withUtcOffset, null, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m65x7b4c7241;
                m65x7b4c7241 = UtcOffsetFormatKt.m65x7b4c7241((DateTimeFormatBuilder.WithUtcOffset) obj);
                return m65x7b4c7241;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ISO_OFFSET_delegate$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8 */
    public static final Unit m65x7b4c7241(DateTimeFormatBuilder.WithUtcOffset optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilderKt.m1967char(optional, AbstractJsonLexerKt.COLON);
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetSecondsOfMinute$default(optional, null, 1, null);
        return Unit.INSTANCE;
    }

    public static final UtcOffsetFormat getISO_OFFSET_BASIC() {
        return (UtcOffsetFormat) ISO_OFFSET_BASIC$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UtcOffsetFormat ISO_OFFSET_BASIC_delegate$lambda$19() {
        return UtcOffsetFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18;
                ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18 = UtcOffsetFormatKt.ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18(DateTimeFormatBuilder.WithUtcOffset build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilderKt.alternativeParsing(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$13;
                ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$13 = UtcOffsetFormatKt.ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$13((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$13;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17;
                ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17 = UtcOffsetFormatKt.ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17((DateTimeFormatBuilder.WithUtcOffset) obj);
                return ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$13(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        alternativeParsing.chars("z");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.optional(alternativeParsing, "Z", new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m62xdee2e2e6;
                m62xdee2e2e6 = UtcOffsetFormatKt.m62xdee2e2e6((DateTimeFormatBuilder.WithUtcOffset) obj);
                return m62xdee2e2e6;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17$lambda$16 */
    public static final Unit m62xdee2e2e6(DateTimeFormatBuilder.WithUtcOffset optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(optional, null, 1, null);
        DateTimeFormatBuilderKt.optional$default(optional, null, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m63x4e1db3e3;
                m63x4e1db3e3 = UtcOffsetFormatKt.m63x4e1db3e3((DateTimeFormatBuilder.WithUtcOffset) obj);
                return m63x4e1db3e3;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15 */
    public static final Unit m63x4e1db3e3(DateTimeFormatBuilder.WithUtcOffset optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(optional, null, 1, null);
        DateTimeFormatBuilderKt.optional$default(optional, null, new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m64x74192c9f;
                m64x74192c9f = UtcOffsetFormatKt.m64x74192c9f((DateTimeFormatBuilder.WithUtcOffset) obj);
                return m64x74192c9f;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ISO_OFFSET_BASIC_delegate$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14 */
    public static final Unit m64x74192c9f(DateTimeFormatBuilder.WithUtcOffset optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetSecondsOfMinute$default(optional, null, 1, null);
        return Unit.INSTANCE;
    }

    public static final UtcOffsetFormat getFOUR_DIGIT_OFFSET() {
        return (UtcOffsetFormat) FOUR_DIGIT_OFFSET$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UtcOffsetFormat FOUR_DIGIT_OFFSET_delegate$lambda$21() {
        return UtcOffsetFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit FOUR_DIGIT_OFFSET_delegate$lambda$21$lambda$20;
                FOUR_DIGIT_OFFSET_delegate$lambda$21$lambda$20 = UtcOffsetFormatKt.FOUR_DIGIT_OFFSET_delegate$lambda$21$lambda$20((DateTimeFormatBuilder.WithUtcOffset) obj);
                return FOUR_DIGIT_OFFSET_delegate$lambda$21$lambda$20;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FOUR_DIGIT_OFFSET_delegate$lambda$21$lambda$20(DateTimeFormatBuilder.WithUtcOffset build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(build, null, 1, null);
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(build, null, 1, null);
        return Unit.INSTANCE;
    }
}
