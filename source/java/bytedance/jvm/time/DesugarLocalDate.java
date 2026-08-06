package bytedance.jvm.time;

import java.util.Objects;
import java.util.function.LongFunction;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DesugarLocalDate {
    public static final LocalDate EPOCH = LocalDate.m87of(1970, 1, 1);
    private static final int SECONDS_PER_DAY = 86400;

    private DesugarLocalDate() {
    }

    public static Stream<LocalDate> datesUntil(LocalDate localDate, LocalDate localDate2) {
        long epochDay = localDate2.toEpochDay();
        long epochDay2 = localDate.toEpochDay();
        if (epochDay < epochDay2) {
            throw new IllegalArgumentException(localDate2 + " < " + localDate);
        }
        return LongStream.range(epochDay2, epochDay).mapToObj(new DesugarLocalDate$$ExternalSyntheticLambda1());
    }

    public static Stream<LocalDate> datesUntil(final LocalDate localDate, LocalDate localDate2, Period period) {
        long prolepticMonth;
        long prolepticMonth2;
        if (period.isZero()) {
            throw new IllegalArgumentException("step is zero");
        }
        long epochDay = localDate2.toEpochDay();
        final long epochDay2 = localDate.toEpochDay();
        long j = epochDay - epochDay2;
        final long totalMonths = period.toTotalMonths();
        final long days = period.getDays();
        if ((totalMonths < 0 && days > 0) || (totalMonths > 0 && days < 0)) {
            throw new IllegalArgumentException("period months and days are of opposite sign");
        }
        if (j == 0) {
            return Stream.empty();
        }
        int i = (totalMonths > 0 || days > 0) ? 1 : -1;
        if ((i < 0) ^ (j < 0)) {
            throw new IllegalArgumentException(localDate2 + (i < 0 ? " > " : " < ") + localDate);
        }
        if (totalMonths == 0) {
            return LongStream.rangeClosed(0L, (j - i) / days).mapToObj(new LongFunction() { // from class: bytedance.jvm.time.DesugarLocalDate$$ExternalSyntheticLambda2
                @Override // java.util.function.LongFunction
                public final Object apply(long j2) {
                    LocalDate ofEpochDay;
                    ofEpochDay = LocalDate.ofEpochDay(epochDay2 + (j2 * days));
                    return ofEpochDay;
                }
            });
        }
        long j2 = ((j * 1600) / ((48699 * totalMonths) + (1600 * days))) + 1;
        long j3 = totalMonths * j2;
        long j4 = days * j2;
        if (totalMonths > 0) {
            prolepticMonth = getProlepticMonth(LocalDate.MAX);
            prolepticMonth2 = getProlepticMonth(localDate);
        } else {
            prolepticMonth = getProlepticMonth(localDate);
            prolepticMonth2 = getProlepticMonth(LocalDate.MIN);
        }
        long j5 = prolepticMonth - prolepticMonth2;
        long j6 = i;
        if (j3 * j6 > j5 || (localDate.plusMonths(j3).toEpochDay() + j4) * j6 >= epochDay * j6) {
            j2--;
            long j7 = j3 - totalMonths;
            long j8 = j4 - days;
            if (j7 * j6 > j5 || (localDate.plusMonths(j7).toEpochDay() + j8) * j6 >= epochDay * j6) {
                j2--;
            }
        }
        return LongStream.rangeClosed(0L, j2).mapToObj(new LongFunction() { // from class: bytedance.jvm.time.DesugarLocalDate$$ExternalSyntheticLambda3
            @Override // java.util.function.LongFunction
            public final Object apply(long j9) {
                LocalDate plusDays;
                plusDays = LocalDate.this.plusMonths(totalMonths * j9).plusDays(days * j9);
                return plusDays;
            }
        });
    }

    public static long toEpochSecond(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localTime, "time");
        Objects.requireNonNull(zoneOffset, "offset");
        return ((localDate.toEpochDay() * 86400) + localTime.toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    public static LocalDate ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return LocalDate.ofEpochDay(UByte$.ExternalSyntheticBackport0.m(instant.getEpochSecond() + zoneId.getRules().getOffset(instant).getTotalSeconds(), SECONDS_PER_DAY));
    }

    private static long getProlepticMonth(LocalDate localDate) {
        return ((localDate.getYear() * 12) + localDate.getMonthValue()) - 1;
    }
}
