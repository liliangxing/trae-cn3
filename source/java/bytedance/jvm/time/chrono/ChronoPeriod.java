package bytedance.jvm.time.chrono;

import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalUnit;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface ChronoPeriod extends TemporalAmount {
    @Override // bytedance.jvm.time.temporal.TemporalAmount
    Temporal addTo(Temporal temporal);

    boolean equals(Object obj);

    @Override // bytedance.jvm.time.temporal.TemporalAmount
    long get(TemporalUnit temporalUnit);

    Chronology getChronology();

    @Override // bytedance.jvm.time.temporal.TemporalAmount
    List<TemporalUnit> getUnits();

    int hashCode();

    ChronoPeriod minus(TemporalAmount temporalAmount);

    ChronoPeriod multipliedBy(int i);

    ChronoPeriod normalized();

    ChronoPeriod plus(TemporalAmount temporalAmount);

    @Override // bytedance.jvm.time.temporal.TemporalAmount
    Temporal subtractFrom(Temporal temporal);

    String toString();

    static ChronoPeriod between(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
        Objects.requireNonNull(chronoLocalDate, "startDateInclusive");
        Objects.requireNonNull(chronoLocalDate2, "endDateExclusive");
        return chronoLocalDate.until(chronoLocalDate2);
    }

    default boolean isZero() {
        Iterator<TemporalUnit> it = getUnits().iterator();
        while (it.hasNext()) {
            if (get(it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    default boolean isNegative() {
        Iterator<TemporalUnit> it = getUnits().iterator();
        while (it.hasNext()) {
            if (get(it.next()) < 0) {
                return true;
            }
        }
        return false;
    }

    default ChronoPeriod negated() {
        return multipliedBy(-1);
    }
}
