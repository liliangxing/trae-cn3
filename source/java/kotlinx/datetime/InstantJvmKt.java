package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZonedDateTime;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.DivRemResult;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
import net.openid.appauth.BuildConfig;

/* compiled from: Instant.kt */
@Metadata(m4d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a\"\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004\u001a\"\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004\u001a\"\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004\u001a\"\u0010\u0012\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u0013"}, m5d2 = {"atZone", "Lbytedance/jvm/time/ZonedDateTime;", "Lkotlinx/datetime/Instant;", "zone", "Lkotlinx/datetime/TimeZone;", "plus", "period", "Lkotlinx/datetime/DateTimePeriod;", "timeZone", "unit", "Lkotlinx/datetime/DateTimeUnit;", "value", BuildConfig.FLAVOR, "minus", BuildConfig.FLAVOR, "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "periodUntil", "other", "until", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class InstantJvmKt {
    private static final ZonedDateTime atZone(Instant instant, TimeZone timeZone) {
        try {
            return instant.getValue().atZone(timeZone.getZoneId());
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant plus(Instant instant, DateTimePeriod period, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            if (period.getTotalMonths() != 0) {
                atZone = atZone.plusMonths(period.getTotalMonths());
            }
            if (period.getDays() != 0) {
                atZone = atZone.plusDays(period.getDays());
            }
            if (period.getTotalNanoseconds() != 0) {
                atZone = atZone.plusNanos(period.getTotalNanoseconds());
            }
            return new Instant(atZone.toInstant());
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit, timeZone)", imports = {}))
    public static final Instant plus(Instant instant, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, 1L, unit, timeZone);
    }

    public static final Instant plus(Instant instant, int i, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, i, unit, timeZone);
    }

    public static final Instant minus(Instant instant, int i, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, -i, unit, timeZone);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit unit, TimeZone timeZone) {
        bytedance.jvm.time.Instant instant2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                instant2 = plus(instant, j, (DateTimeUnit.TimeBased) unit).getValue();
                instant2.atZone(timeZone.getZoneId());
            } else if (unit instanceof DateTimeUnit.DayBased) {
                instant2 = atZone.plusDays(MathJvmKt.safeMultiply(j, ((DateTimeUnit.DayBased) unit).getDays())).toInstant();
            } else {
                if (!(unit instanceof DateTimeUnit.MonthBased)) {
                    throw new NoWhenBranchMatchedException();
                }
                instant2 = atZone.plusMonths(MathJvmKt.safeMultiply(j, ((DateTimeUnit.MonthBased) unit).getMonths())).toInstant();
            }
            return new Instant(instant2);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                throw new DateTimeArithmeticException("Instant " + instant + " cannot be represented as local date when adding " + j + ' ' + unit + " to it", e);
            }
            throw e;
        }
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            DivRemResult multiplyAndDivide = MathKt.multiplyAndDivide(j, unit.getNanoseconds(), 1000000000L);
            bytedance.jvm.time.Instant plusNanos = instant.getValue().plusSeconds(multiplyAndDivide.getQ()).plusNanos(multiplyAndDivide.getR());
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                return j > 0 ? Instant.INSTANCE.getMAX$kotlinx_datetime_release() : Instant.INSTANCE.getMIN$kotlinx_datetime_release();
            }
            throw e;
        }
    }

    public static final DateTimePeriod periodUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        ZonedDateTime atZone = atZone(instant, timeZone);
        Temporal atZone2 = atZone(other, timeZone);
        long until = atZone.until(atZone2, ChronoUnit.MONTHS);
        ZonedDateTime plusMonths = atZone.plusMonths(until);
        long until2 = plusMonths.until(atZone2, ChronoUnit.DAYS);
        long until3 = plusMonths.plusDays(until2).until(atZone2, ChronoUnit.NANOS);
        if (until > 2147483647L || until < -2147483648L) {
            throw new DateTimeArithmeticException("The number of months between " + instant + " and " + other + " does not fit in an Int");
        }
        return DateTimePeriodKt.buildDateTimePeriod((int) until, (int) until2, until3);
    }

    public static final long until(Instant instant, Instant other, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            Temporal atZone2 = atZone(other, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                return InstantKt.until(instant, other, (DateTimeUnit.TimeBased) unit);
            }
            if (unit instanceof DateTimeUnit.DayBased) {
                return atZone.until(atZone2, ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays();
            }
            if (unit instanceof DateTimeUnit.MonthBased) {
                return atZone.until(atZone2, ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths();
            }
            throw new NoWhenBranchMatchedException();
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        } catch (ArithmeticException unused) {
            if (instant.getValue().compareTo(other.getValue()) < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }
}
