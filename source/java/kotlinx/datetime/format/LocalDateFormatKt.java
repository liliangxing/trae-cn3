package kotlinx.datetime.format;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.DayOfWeekNames;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateFormat.kt */
@Metadata(m4d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a%\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\b\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\"!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016\"\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m5d2 = {"toKotlinCode", BuildConfig.FLAVOR, "Lkotlinx/datetime/format/MonthNames;", "Lkotlinx/datetime/format/DayOfWeekNames;", "requireParsedField", "T", "field", "name", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "YEAR_OF_ERA_COMMENT", "yearOfEra", BuildConfig.FLAVOR, "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "padding", "Lkotlinx/datetime/format/Padding;", "yearOfEraTwoDigits", "baseYear", BuildConfig.FLAVOR, "ISO_DATE", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "getISO_DATE", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_DATE$delegate", "Lkotlin/Lazy;", "ISO_DATE_BASIC", "getISO_DATE_BASIC", "ISO_DATE_BASIC$delegate", "emptyIncompleteLocalDate", "Lkotlinx/datetime/format/IncompleteLocalDate;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDateFormatKt {
    private static final String YEAR_OF_ERA_COMMENT = " /** TODO: the original format had an `y` directive, so the behavior is different on years earlier than 1 AD. See the [kotlinx.datetime.format.byUnicodePattern] documentation for details. */";
    private static final Lazy ISO_DATE$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormat ISO_DATE_delegate$lambda$1;
            ISO_DATE_delegate$lambda$1 = LocalDateFormatKt.ISO_DATE_delegate$lambda$1();
            return ISO_DATE_delegate$lambda$1;
        }
    });
    private static final Lazy ISO_DATE_BASIC$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DateTimeFormat ISO_DATE_BASIC_delegate$lambda$3;
            ISO_DATE_BASIC_delegate$lambda$3 = LocalDateFormatKt.ISO_DATE_BASIC_delegate$lambda$3();
            return ISO_DATE_BASIC_delegate$lambda$3;
        }
    });
    private static final IncompleteLocalDate emptyIncompleteLocalDate = new IncompleteLocalDate(null, null, null, null, 15, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toKotlinCode(MonthNames monthNames) {
        List<String> names = monthNames.getNames();
        if (Intrinsics.areEqual(names, MonthNames.INSTANCE.getENGLISH_FULL().getNames())) {
            DayOfWeekNames.Companion companion = DayOfWeekNames.INSTANCE;
            return "MonthNames.ENGLISH_FULL";
        }
        if (!Intrinsics.areEqual(names, MonthNames.INSTANCE.getENGLISH_ABBREVIATED().getNames())) {
            return CollectionsKt.joinToString$default(monthNames.getNames(), ", ", "MonthNames(", ")", 0, null, LocalDateFormatKt$toKotlinCode$1.INSTANCE, 24, null);
        }
        DayOfWeekNames.Companion companion2 = DayOfWeekNames.INSTANCE;
        return "MonthNames.ENGLISH_ABBREVIATED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toKotlinCode(DayOfWeekNames dayOfWeekNames) {
        List<String> names = dayOfWeekNames.getNames();
        if (Intrinsics.areEqual(names, DayOfWeekNames.INSTANCE.getENGLISH_FULL().getNames())) {
            DayOfWeekNames.Companion companion = DayOfWeekNames.INSTANCE;
            return "DayOfWeekNames.ENGLISH_FULL";
        }
        if (!Intrinsics.areEqual(names, DayOfWeekNames.INSTANCE.getENGLISH_ABBREVIATED().getNames())) {
            return CollectionsKt.joinToString$default(dayOfWeekNames.getNames(), ", ", "DayOfWeekNames(", ")", 0, null, LocalDateFormatKt$toKotlinCode$2.INSTANCE, 24, null);
        }
        DayOfWeekNames.Companion companion2 = DayOfWeekNames.INSTANCE;
        return "DayOfWeekNames.ENGLISH_ABBREVIATED";
    }

    public static final <T> T requireParsedField(T t, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (t != null) {
            return t;
        }
        throw new DateTimeFormatException("Can not create a " + name + " from the given input: the field " + name + " is missing");
    }

    public static final void yearOfEra(DateTimeFormatBuilder.WithDate withDate, Padding padding) {
        Intrinsics.checkNotNullParameter(withDate, "<this>");
        Intrinsics.checkNotNullParameter(padding, "padding");
        if (withDate instanceof AbstractWithDateBuilder) {
            ((AbstractWithDateBuilder) withDate).addFormatStructureForDate(new BasicFormatStructure(new YearDirective(padding, true)));
        }
    }

    public static final void yearOfEraTwoDigits(DateTimeFormatBuilder.WithDate withDate, int i) {
        Intrinsics.checkNotNullParameter(withDate, "<this>");
        if (withDate instanceof AbstractWithDateBuilder) {
            ((AbstractWithDateBuilder) withDate).addFormatStructureForDate(new BasicFormatStructure(new ReducedYearDirective(i, true)));
        }
    }

    public static final DateTimeFormat<LocalDate> getISO_DATE() {
        return (DateTimeFormat) ISO_DATE$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormat ISO_DATE_delegate$lambda$1() {
        return LocalDateFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATE_delegate$lambda$1$lambda$0;
                ISO_DATE_delegate$lambda$1$lambda$0 = LocalDateFormatKt.ISO_DATE_delegate$lambda$1$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return ISO_DATE_delegate$lambda$1$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_DATE_delegate$lambda$1$lambda$0(DateTimeFormatBuilder.WithDate build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilder.WithDate.DefaultImpls.year$default(build, null, 1, null);
        DateTimeFormatBuilder.WithDate withDate = build;
        DateTimeFormatBuilderKt.m1967char(withDate, '-');
        DateTimeFormatBuilder.WithDate.DefaultImpls.monthNumber$default(build, null, 1, null);
        DateTimeFormatBuilderKt.m1967char(withDate, '-');
        DateTimeFormatBuilder.WithDate.DefaultImpls.dayOfMonth$default(build, null, 1, null);
        return Unit.INSTANCE;
    }

    public static final DateTimeFormat<LocalDate> getISO_DATE_BASIC() {
        return (DateTimeFormat) ISO_DATE_BASIC$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormat ISO_DATE_BASIC_delegate$lambda$3() {
        return LocalDateFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.LocalDateFormatKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATE_BASIC_delegate$lambda$3$lambda$2;
                ISO_DATE_BASIC_delegate$lambda$3$lambda$2 = LocalDateFormatKt.ISO_DATE_BASIC_delegate$lambda$3$lambda$2((DateTimeFormatBuilder.WithDate) obj);
                return ISO_DATE_BASIC_delegate$lambda$3$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ISO_DATE_BASIC_delegate$lambda$3$lambda$2(DateTimeFormatBuilder.WithDate build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilder.WithDate.DefaultImpls.year$default(build, null, 1, null);
        DateTimeFormatBuilder.WithDate.DefaultImpls.monthNumber$default(build, null, 1, null);
        DateTimeFormatBuilder.WithDate.DefaultImpls.dayOfMonth$default(build, null, 1, null);
        return Unit.INSTANCE;
    }
}
