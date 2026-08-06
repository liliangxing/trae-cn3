package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormatBuilder;

/* compiled from: LocalDateTimeFormat.kt */
@Metadata(m4d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m5d2 = {"ISO_DATETIME", "Lkotlinx/datetime/format/LocalDateTimeFormat;", "getISO_DATETIME", "()Lkotlinx/datetime/format/LocalDateTimeFormat;", "ISO_DATETIME$delegate", "Lkotlin/Lazy;", "emptyIncompleteLocalDateTime", "Lkotlinx/datetime/format/IncompleteLocalDateTime;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDateTimeFormatKt {
    private static final Lazy ISO_DATETIME$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LocalDateTimeFormat ISO_DATETIME_delegate$lambda$3;
            ISO_DATETIME_delegate$lambda$3 = LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3();
            return ISO_DATETIME_delegate$lambda$3;
        }
    });
    private static final IncompleteLocalDateTime emptyIncompleteLocalDateTime = new IncompleteLocalDateTime(null, null, 3, null);

    public static final LocalDateTimeFormat getISO_DATETIME() {
        return (LocalDateTimeFormat) ISO_DATETIME$delegate.getValue();
    }

    public static final LocalDateTimeFormat ISO_DATETIME_delegate$lambda$3() {
        return LocalDateTimeFormat.INSTANCE.build(new Function1() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATETIME_delegate$lambda$3$lambda$2;
                ISO_DATETIME_delegate$lambda$3$lambda$2 = LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3$lambda$2((DateTimeFormatBuilder.WithDateTime) obj);
                return ISO_DATETIME_delegate$lambda$3$lambda$2;
            }
        });
    }

    public static final Unit ISO_DATETIME_delegate$lambda$3$lambda$2(DateTimeFormatBuilder.WithDateTime build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        build.date(LocalDateFormatKt.getISO_DATE());
        DateTimeFormatBuilderKt.alternativeParsing(build, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0;
                ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0 = LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.LocalDateTimeFormatKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1;
                ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1 = LocalDateTimeFormatKt.ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1((DateTimeFormatBuilder.WithDateTime) obj);
                return ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1;
            }
        });
        build.time(LocalTimeFormatKt.getISO_TIME());
        return Unit.INSTANCE;
    }

    public static final Unit ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$0(DateTimeFormatBuilder.WithDateTime alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.m1967char(alternativeParsing, 't');
        return Unit.INSTANCE;
    }

    public static final Unit ISO_DATETIME_delegate$lambda$3$lambda$2$lambda$1(DateTimeFormatBuilder.WithDateTime alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilderKt.m1967char(alternativeParsing, 'T');
        return Unit.INSTANCE;
    }
}
