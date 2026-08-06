package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDate.kt */
@Metadata(m4d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001a\u0010\u0011\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0012\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0012\u0010\u0014\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5d2 = {"plus", "Lkotlinx/datetime/LocalDate;", "unit", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "value", BuildConfig.FLAVOR, "minus", BuildConfig.FLAVOR, "minEpochDay", "maxEpochDay", "ofEpochDayChecked", "Lbytedance/jvm/time/LocalDate;", "epochDay", "period", "Lkotlinx/datetime/DatePeriod;", "periodUntil", "other", "until", "daysUntil", "monthsUntil", "yearsUntil", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDateJvmKt {
    private static final long minEpochDay = bytedance.jvm.time.LocalDate.MIN.toEpochDay();
    private static final long maxEpochDay = bytedance.jvm.time.LocalDate.MAX.toEpochDay();

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit)", imports = {}))
    public static final LocalDate plus(LocalDate localDate, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(localDate, 1L, unit);
    }

    public static final LocalDate plus(LocalDate localDate, int i, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(localDate, i, unit);
    }

    public static final LocalDate minus(LocalDate localDate, int i, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(localDate, -i, unit);
    }

    public static final LocalDate plus(LocalDate localDate, long j, DateTimeUnit.DateBased unit) {
        bytedance.jvm.time.LocalDate plusMonths;
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            if (unit instanceof DateTimeUnit.DayBased) {
                plusMonths = ofEpochDayChecked(MathJvmKt.safeAdd(localDate.getValue().toEpochDay(), MathJvmKt.safeMultiply(j, ((DateTimeUnit.DayBased) unit).getDays())));
            } else {
                if (!(unit instanceof DateTimeUnit.MonthBased)) {
                    throw new NoWhenBranchMatchedException();
                }
                plusMonths = localDate.getValue().plusMonths(MathJvmKt.safeMultiply(j, ((DateTimeUnit.MonthBased) unit).getMonths()));
            }
            return new LocalDate(plusMonths);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                throw new DateTimeArithmeticException("The result of adding " + j + " of " + unit + " to " + localDate + " is out of LocalDate range.", e);
            }
            throw e;
        }
    }

    private static final bytedance.jvm.time.LocalDate ofEpochDayChecked(long j) {
        long j2 = minEpochDay;
        boolean z = false;
        if (j <= maxEpochDay && j2 <= j) {
            z = true;
        }
        if (!z) {
            throw new DateTimeException("The resulting day " + j + " is out of supported LocalDate range.");
        }
        bytedance.jvm.time.LocalDate ofEpochDay = bytedance.jvm.time.LocalDate.ofEpochDay(j);
        Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
        return ofEpochDay;
    }

    public static final LocalDate plus(LocalDate localDate, DatePeriod period) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        try {
            bytedance.jvm.time.LocalDate value = localDate.getValue();
            if (period.getTotalMonths() != 0) {
                value = value.plusMonths(period.getTotalMonths());
            }
            if (period.getDays() != 0) {
                value = value.plusDays(period.getDays());
            }
            return new LocalDate(value);
        } catch (DateTimeException unused) {
            throw new DateTimeArithmeticException("The result of adding " + localDate.getValue() + " to " + localDate + " is out of LocalDate range.");
        }
    }

    public static final DatePeriod periodUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        bytedance.jvm.time.LocalDate value = localDate.getValue();
        Temporal value2 = other.getValue();
        long until = value.until(value2, ChronoUnit.MONTHS);
        long until2 = value.plusMonths(until).until(value2, ChronoUnit.DAYS);
        if (until > 2147483647L || until < -2147483648L) {
            throw new DateTimeArithmeticException("The number of months between " + localDate + " and " + other + " does not fit in an Int");
        }
        return new DatePeriod((int) until, (int) until2);
    }

    public static final int until(LocalDate localDate, LocalDate other, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit instanceof DateTimeUnit.MonthBased) {
            return MathKt.clampToInt(localDate.getValue().until(other.getValue(), ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths());
        }
        if (unit instanceof DateTimeUnit.DayBased) {
            return MathKt.clampToInt(localDate.getValue().until(other.getValue(), ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int daysUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt(localDate.getValue().until(other.getValue(), ChronoUnit.DAYS));
    }

    public static final int monthsUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt(localDate.getValue().until(other.getValue(), ChronoUnit.MONTHS));
    }

    public static final int yearsUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt(localDate.getValue().until(other.getValue(), ChronoUnit.YEARS));
    }
}
