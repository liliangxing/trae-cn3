package bytedance.jvm.time.temporal;

import bytedance.jvm.time.Duration;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.ChronoLocalDateTime;
import bytedance.jvm.time.chrono.ChronoZonedDateTime;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface TemporalUnit {
    <R extends Temporal> R addTo(R r, long j);

    long between(Temporal temporal, Temporal temporal2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isTimeBased();

    String toString();

    default boolean isSupportedBy(Temporal temporal) {
        if (temporal instanceof LocalTime) {
            return isTimeBased();
        }
        if (temporal instanceof ChronoLocalDate) {
            return isDateBased();
        }
        if ((temporal instanceof ChronoLocalDateTime) || (temporal instanceof ChronoZonedDateTime)) {
            return true;
        }
        try {
            temporal.plus(1L, this);
            return true;
        } catch (UnsupportedTemporalTypeException | RuntimeException unused) {
            return false;
        } catch (RuntimeException unused2) {
            temporal.plus(-1L, this);
            return true;
        }
    }
}
