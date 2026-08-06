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
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface ChronoZonedDateTime<D extends ChronoLocalDate> extends Temporal, Comparable<ChronoZonedDateTime<?>> {
    boolean equals(Object obj);

    ZoneOffset getOffset();

    ZoneId getZone();

    int hashCode();

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    boolean isSupported(TemporalField temporalField);

    @Override // bytedance.jvm.time.temporal.Temporal
    ChronoZonedDateTime<D> plus(long j, TemporalUnit temporalUnit);

    /* renamed from: toLocalDateTime */
    ChronoLocalDateTime<D> toLocalDateTime2();

    String toString();

    @Override // bytedance.jvm.time.temporal.Temporal
    ChronoZonedDateTime<D> with(TemporalField temporalField, long j);

    /* renamed from: withEarlierOffsetAtOverlap */
    ChronoZonedDateTime<D> withEarlierOffsetAtOverlap2();

    /* renamed from: withLaterOffsetAtOverlap */
    ChronoZonedDateTime<D> withLaterOffsetAtOverlap2();

    /* renamed from: withZoneSameInstant */
    ChronoZonedDateTime<D> withZoneSameInstant2(ZoneId zoneId);

    /* renamed from: withZoneSameLocal */
    ChronoZonedDateTime<D> withZoneSameLocal2(ZoneId zoneId);

    static Comparator<ChronoZonedDateTime<?>> timeLineOrder() {
        return new ChronoZonedDateTime$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ int lambda$timeLineOrder$c441aadb$1(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int compare = Long.compare(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
        return compare == 0 ? Long.compare(chronoZonedDateTime.toLocalTime().getNano(), chronoZonedDateTime2.toLocalTime().getNano()) : compare;
    }

    static ChronoZonedDateTime<?> from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ChronoZonedDateTime) {
            return (ChronoZonedDateTime) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology == null) {
            throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + temporalAccessor.getClass());
        }
        return chronology.zonedDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) {
                return temporalField.range();
            }
            return toLocalDateTime2().range(temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.ChronoZonedDateTime$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06331 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = C06331.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
            if (i == 1) {
                throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i == 2) {
                return getOffset().getTotalSeconds();
            }
            return toLocalDateTime2().get(temporalField);
        }
        return super.get(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = C06331.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
            if (i == 1) {
                return toEpochSecond();
            }
            if (i == 2) {
                return getOffset().getTotalSeconds();
            }
            return toLocalDateTime2().getLong(temporalField);
        }
        return temporalField.getFrom(this);
    }

    default D toLocalDate() {
        return toLocalDateTime2().toLocalDate();
    }

    default LocalTime toLocalTime() {
        return toLocalDateTime2().toLocalTime();
    }

    default Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default boolean isSupported(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit != ChronoUnit.FOREVER : temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoZonedDateTime<D> with(TemporalAdjuster temporalAdjuster) {
        return ChronoZonedDateTimeImpl.ensureValid(getChronology(), super.with(temporalAdjuster));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoZonedDateTime<D> plus(TemporalAmount temporalAmount) {
        return ChronoZonedDateTimeImpl.ensureValid(getChronology(), super.plus(temporalAmount));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoZonedDateTime<D> minus(TemporalAmount temporalAmount) {
        return ChronoZonedDateTimeImpl.ensureValid(getChronology(), super.minus(temporalAmount));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    default ChronoZonedDateTime<D> minus(long j, TemporalUnit temporalUnit) {
        return ChronoZonedDateTimeImpl.ensureValid(getChronology(), super.minus(j, temporalUnit));
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId()) {
            return (R) getZone();
        }
        if (temporalQuery == TemporalQueries.offset()) {
            return (R) getOffset();
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

    default String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    default Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    default long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - getOffset().getTotalSeconds();
    }

    @Override // java.lang.Comparable
    default int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int compare = Long.compare(toEpochSecond(), chronoZonedDateTime.toEpochSecond());
        if (compare != 0) {
            return compare;
        }
        int nano = toLocalTime().getNano() - chronoZonedDateTime.toLocalTime().getNano();
        if (nano != 0) {
            return nano;
        }
        int compareTo = toLocalDateTime2().compareTo(chronoZonedDateTime.toLocalDateTime2());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getZone().getId().compareTo(chronoZonedDateTime.getZone().getId());
        return compareTo2 == 0 ? getChronology().compareTo(chronoZonedDateTime.getChronology()) : compareTo2;
    }

    default boolean isBefore(ChronoZonedDateTime<?> chronoZonedDateTime) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = chronoZonedDateTime.toEpochSecond();
        return epochSecond < epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() < chronoZonedDateTime.toLocalTime().getNano());
    }

    default boolean isAfter(ChronoZonedDateTime<?> chronoZonedDateTime) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = chronoZonedDateTime.toEpochSecond();
        return epochSecond > epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() > chronoZonedDateTime.toLocalTime().getNano());
    }

    default boolean isEqual(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return toEpochSecond() == chronoZonedDateTime.toEpochSecond() && toLocalTime().getNano() == chronoZonedDateTime.toLocalTime().getNano();
    }
}
