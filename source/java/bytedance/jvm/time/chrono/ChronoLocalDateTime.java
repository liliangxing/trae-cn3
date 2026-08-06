package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.ChronoLocalDate;
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
import java.util.Comparator;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface ChronoLocalDateTime<D extends ChronoLocalDate> extends Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    /* renamed from: atZone */
    ChronoZonedDateTime<D> atZone2(ZoneId zoneId);

    boolean equals(Object obj);

    int hashCode();

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    boolean isSupported(TemporalField temporalField);

    @Override // bytedance.jvm.time.temporal.Temporal
    ChronoLocalDateTime<D> plus(long j, TemporalUnit temporalUnit);

    D toLocalDate();

    LocalTime toLocalTime();

    String toString();

    @Override // bytedance.jvm.time.temporal.Temporal
    ChronoLocalDateTime<D> with(TemporalField temporalField, long j);

    static Comparator<ChronoLocalDateTime<?>> timeLineOrder() {
        return new ChronoLocalDateTime$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ int lambda$timeLineOrder$8868da8e$1(ChronoLocalDateTime chronoLocalDateTime, ChronoLocalDateTime chronoLocalDateTime2) {
        int compare = Long.compare(chronoLocalDateTime.toLocalDate().toEpochDay(), chronoLocalDateTime2.toLocalDate().toEpochDay());
        return compare == 0 ? Long.compare(chronoLocalDateTime.toLocalTime().toNanoOfDay(), chronoLocalDateTime2.toLocalTime().toNanoOfDay()) : compare;
    }

    static ChronoLocalDateTime<?> from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ChronoLocalDateTime) {
            return (ChronoLocalDateTime) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology == null) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass());
        }
        return chronology.localDateTime(temporalAccessor);
    }

    default Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit != ChronoUnit.FOREVER : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDateTime<D> with(TemporalAdjuster temporalAdjuster) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.with(temporalAdjuster));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDateTime<D> plus(TemporalAmount temporalAmount) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.plus(temporalAmount));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDateTime<D> minus(TemporalAmount temporalAmount) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.minus(temporalAmount));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoLocalDateTime<D> minus(long j, TemporalUnit temporalUnit) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.minus(j, temporalUnit));
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) toLocalTime();
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    default Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    default String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    default Instant toInstant(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(toEpochSecond(zoneOffset), toLocalTime().getNano());
    }

    default long toEpochSecond(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    @Override // java.lang.Comparable
    default int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        int compareTo = toLocalDate().compareTo(chronoLocalDateTime.toLocalDate());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = toLocalTime().compareTo(chronoLocalDateTime.toLocalTime());
        return compareTo2 == 0 ? getChronology().compareTo(chronoLocalDateTime.getChronology()) : compareTo2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [bytedance.jvm.time.chrono.ChronoLocalDate] */
    default boolean isAfter(ChronoLocalDateTime<?> chronoLocalDateTime) {
        long epochDay = toLocalDate().toEpochDay();
        long epochDay2 = chronoLocalDateTime.toLocalDate().toEpochDay();
        return epochDay > epochDay2 || (epochDay == epochDay2 && toLocalTime().toNanoOfDay() > chronoLocalDateTime.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [bytedance.jvm.time.chrono.ChronoLocalDate] */
    default boolean isBefore(ChronoLocalDateTime<?> chronoLocalDateTime) {
        long epochDay = toLocalDate().toEpochDay();
        long epochDay2 = chronoLocalDateTime.toLocalDate().toEpochDay();
        return epochDay < epochDay2 || (epochDay == epochDay2 && toLocalTime().toNanoOfDay() < chronoLocalDateTime.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [bytedance.jvm.time.chrono.ChronoLocalDate] */
    default boolean isEqual(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return toLocalTime().toNanoOfDay() == chronoLocalDateTime.toLocalTime().toNanoOfDay() && toLocalDate().toEpochDay() == chronoLocalDateTime.toLocalDate().toEpochDay();
    }
}
