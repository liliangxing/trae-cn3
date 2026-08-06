package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.format.DateTimeFormatter;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface ChronoLocalDate extends Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {
    boolean equals(Object obj);

    Chronology getChronology();

    int hashCode();

    int lengthOfMonth();

    String toString();

    @Override // bytedance.jvm.time.temporal.Temporal
    long until(Temporal temporal, TemporalUnit temporalUnit);

    ChronoPeriod until(ChronoLocalDate chronoLocalDate);

    static Comparator<ChronoLocalDate> timeLineOrder() {
        return new ChronoLocalDate$$ExternalSyntheticLambda0();
    }

    static ChronoLocalDate from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ChronoLocalDate) {
            return (ChronoLocalDate) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology == null) {
            throw new DateTimeException("Unable to obtain ChronoLocalDate from TemporalAccessor: " + temporalAccessor.getClass());
        }
        return chronology.date(temporalAccessor);
    }

    default Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    default boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    default int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isDateBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.isDateBased();
        }
        return temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.with(temporalAdjuster));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDate with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return ChronoLocalDateImpl.ensureValid(getChronology(), temporalField.adjustInto(this, j));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDate plus(TemporalAmount temporalAmount) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.plus(temporalAmount));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDate plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return ChronoLocalDateImpl.ensureValid(getChronology(), temporalUnit.addTo(this, j));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDate minus(TemporalAmount temporalAmount) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.minus(temporalAmount));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.minus(j, temporalUnit));
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localTime()) {
            return null;
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.DAYS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    default Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    default String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    default ChronoLocalDateTime<?> atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.m119of(this, localTime);
    }

    default long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    default int compareTo(ChronoLocalDate chronoLocalDate) {
        int compare = Long.compare(toEpochDay(), chronoLocalDate.toEpochDay());
        return compare == 0 ? getChronology().compareTo(chronoLocalDate.getChronology()) : compare;
    }

    default boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() > chronoLocalDate.toEpochDay();
    }

    default boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() < chronoLocalDate.toEpochDay();
    }

    default boolean isEqual(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() == chronoLocalDate.toEpochDay();
    }
}
