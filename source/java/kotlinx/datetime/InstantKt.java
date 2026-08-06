package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.DateTimeComponentsKt;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.internal.MathKt;
import net.openid.appauth.BuildConfig;

/* compiled from: Instant.kt */
@Metadata(m4d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0006H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u0013\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u0014\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u0007\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u001a\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u001a\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010\u001a\"\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\"\u0010\u0007\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\u0007\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010\u001a\"\u0010\u0018\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u000e\u0010\u001d\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m5d2 = {"isDistantPast", BuildConfig.FLAVOR, "Lkotlinx/datetime/Instant;", "(Lkotlinx/datetime/Instant;)Z", "isDistantFuture", "toInstant", BuildConfig.FLAVOR, "minus", "period", "Lkotlinx/datetime/DateTimePeriod;", "timeZone", "Lkotlinx/datetime/TimeZone;", "until", BuildConfig.FLAVOR, "other", "unit", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "daysUntil", BuildConfig.FLAVOR, "monthsUntil", "yearsUntil", "Lkotlinx/datetime/DateTimeUnit;", "plus", "value", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "offset", "Lkotlinx/datetime/UtcOffset;", "DISTANT_PAST_SECONDS", "DISTANT_FUTURE_SECONDS", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class InstantKt {
    public static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    public static final long DISTANT_PAST_SECONDS = -3217862419201L;

    public static final boolean isDistantPast(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo(Instant.INSTANCE.getDISTANT_PAST()) <= 0;
    }

    public static final boolean isDistantFuture(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo(Instant.INSTANCE.getDISTANT_FUTURE()) >= 0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "Instant.parse(this)", imports = {}))
    public static final Instant toInstant(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Instant.Companion.parse$default(Instant.INSTANCE, str, null, 2, null);
    }

    public static final Instant minus(Instant instant, DateTimePeriod period, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (period.getTotalNanoseconds() != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-period.getTotalMonths(), -period.getDays(), -period.getTotalNanoseconds()), timeZone);
        }
        return plus(InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-period.getTotalMonths(), -period.getDays(), -(period.getTotalNanoseconds() + 1)), timeZone), 1, DateTimeUnit.INSTANCE.getNANOSECOND());
    }

    public static final long until(Instant instant, Instant other, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            return MathKt.multiplyAddAndDivide(other.getEpochSeconds() - instant.getEpochSeconds(), 1000000000L, other.getNanosecondsOfSecond() - instant.getNanosecondsOfSecond(), unit.getNanoseconds());
        } catch (ArithmeticException unused) {
            if (instant.compareTo(other) < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    public static final int daysUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.INSTANCE.getDAY(), timeZone));
    }

    public static final int monthsUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.INSTANCE.getMONTH(), timeZone));
    }

    public static final int yearsUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.INSTANCE.getYEAR(), timeZone));
    }

    public static final DateTimePeriod minus(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.periodUntil(other, instant, timeZone);
    }

    @Deprecated(message = "Use the minus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.minus(1, unit, timeZone)", imports = {}))
    public static final Instant minus(Instant instant, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.plus(instant, -1, unit, timeZone);
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit)", imports = {}))
    public static final Instant plus(Instant instant, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(instant, 1L, unit);
    }

    @Deprecated(message = "Use the minus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.minus(1, unit)", imports = {}))
    public static final Instant minus(Instant instant, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(instant, -1L, unit);
    }

    public static final Instant plus(Instant instant, int i, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(instant, i, unit);
    }

    public static final Instant minus(Instant instant, int i, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return minus(instant, i, unit);
    }

    public static final Instant minus(Instant instant, long j, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (j != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, -j, unit, timeZone);
        }
        return InstantJvmKt.plus(InstantJvmKt.plus(instant, -(j + 1), unit, timeZone), 1, unit, timeZone);
    }

    public static final Instant minus(Instant instant, long j, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, -j, unit);
        }
        return plus(InstantJvmKt.plus(instant, -(j + 1), unit), 1, unit);
    }

    public static final long minus(Instant instant, Instant other, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.until(other, instant, unit, timeZone);
    }

    public static final long minus(Instant instant, Instant other, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return until(other, instant, unit);
    }

    public static /* synthetic */ String format$default(Instant instant, DateTimeFormat dateTimeFormat, UtcOffset utcOffset, int i, Object obj) {
        if ((i & 2) != 0) {
            utcOffset = UtcOffset.INSTANCE.getZERO();
        }
        return format(instant, dateTimeFormat, utcOffset);
    }

    public static final String format(final Instant instant, DateTimeFormat<DateTimeComponents> format, final UtcOffset offset) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(offset, "offset");
        return DateTimeComponentsKt.format(format, new Function1() { // from class: kotlinx.datetime.InstantKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit format$lambda$2;
                format$lambda$2 = InstantKt.format$lambda$2(Instant.this, offset, (DateTimeComponents) obj);
                return format$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit format$lambda$2(Instant instant, UtcOffset offset, DateTimeComponents format) {
        Intrinsics.checkNotNullParameter(instant, "$instant");
        Intrinsics.checkNotNullParameter(offset, "$offset");
        Intrinsics.checkNotNullParameter(format, "$this$format");
        format.setDateTimeOffset(instant, offset);
        return Unit.INSTANCE;
    }
}
