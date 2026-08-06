package bytedance.jvm.time;

import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import java.math.BigDecimal;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DesugarDuration {
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_MINUTE = 60;

    public static long dividedBy(Duration duration, Duration duration2) {
        Objects.requireNonNull(duration2, "divisor");
        return toBigDecimalSeconds(duration).divideToIntegralValue(toBigDecimalSeconds(duration2)).longValueExact();
    }

    public static long toSeconds(Duration duration) {
        return duration.getSeconds();
    }

    public static long toDaysPart(Duration duration) {
        return duration.getSeconds() / 86400;
    }

    public static int toHoursPart(Duration duration) {
        return (int) (duration.toHours() % 24);
    }

    public static int toMinutesPart(Duration duration) {
        return (int) (duration.toMinutes() % 60);
    }

    public static int toSecondsPart(Duration duration) {
        return (int) (duration.getSeconds() % 60);
    }

    public static int toMillisPart(Duration duration) {
        return duration.getNano() / 1000000;
    }

    public static int toNanosPart(Duration duration) {
        return duration.getNano();
    }

    public static Duration truncatedTo(Duration duration, TemporalUnit temporalUnit) {
        long seconds = duration.getSeconds();
        int nano = duration.getNano();
        Objects.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.SECONDS && (seconds >= 0 || nano == 0)) {
            return Duration.ofSeconds(seconds);
        }
        if (temporalUnit == ChronoUnit.NANOS) {
            return duration;
        }
        Duration duration2 = temporalUnit.getDuration();
        if (duration2.getSeconds() > 86400) {
            throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
        }
        long nanos = duration2.toNanos();
        if (NANOS_PER_DAY % nanos != 0) {
            throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
        }
        long j = ((seconds % 86400) * 1000000000) + nano;
        return duration.plusNanos(((j / nanos) * nanos) - j);
    }

    private static BigDecimal toBigDecimalSeconds(Duration duration) {
        return BigDecimal.valueOf(duration.getSeconds()).add(BigDecimal.valueOf(duration.getNano(), 9));
    }
}
