package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.ResolverStyle;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface Chronology extends Comparable<Chronology> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    int compareTo(Chronology chronology);

    ChronoLocalDate date(int i, int i2, int i3);

    ChronoLocalDate date(TemporalAccessor temporalAccessor);

    ChronoLocalDate dateEpochDay(long j);

    ChronoLocalDate dateYearDay(int i, int i2);

    boolean equals(Object obj);

    Era eraOf(int i);

    List<Era> eras();

    String getCalendarType();

    String getId();

    int hashCode();

    boolean isLeapYear(long j);

    int prolepticYear(Era era, int i);

    ValueRange range(ChronoField chronoField);

    ChronoLocalDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle);

    String toString();

    static Chronology from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        return (Chronology) UByte$.ExternalSyntheticBackport0.m((Chronology) temporalAccessor.query(TemporalQueries.chronology()), IsoChronology.INSTANCE);
    }

    static Chronology ofLocale(Locale locale) {
        return AbstractChronology.ofLocale(locale);
    }

    /* renamed from: of */
    static Chronology m120of(String str) {
        return AbstractChronology.m118of(str);
    }

    static Set<Chronology> getAvailableChronologies() {
        return AbstractChronology.getAvailableChronologies();
    }

    default ChronoLocalDate date(Era era, int i, int i2, int i3) {
        return date(prolepticYear(era, i), i2, i3);
    }

    default ChronoLocalDate dateYearDay(Era era, int i, int i2) {
        return dateYearDay(prolepticYear(era, i), i2);
    }

    default ChronoLocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    default ChronoLocalDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    default ChronoLocalDate dateNow(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        return date(LocalDate.now(clock));
    }

    default ChronoLocalDateTime<? extends ChronoLocalDate> localDateTime(TemporalAccessor temporalAccessor) {
        try {
            return date(temporalAccessor).atTime(LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [bytedance.jvm.time.chrono.ChronoZonedDateTime<? extends bytedance.jvm.time.chrono.ChronoLocalDate>, bytedance.jvm.time.chrono.ChronoZonedDateTime] */
    default ChronoZonedDateTime<? extends ChronoLocalDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        try {
            ZoneId from = ZoneId.from(temporalAccessor);
            try {
                temporalAccessor = zonedDateTime(Instant.from(temporalAccessor), from);
                return temporalAccessor;
            } catch (DateTimeException unused) {
                return ChronoZonedDateTimeImpl.ofBest(ChronoLocalDateTimeImpl.ensureValid(this, localDateTime(temporalAccessor)), from, null);
            }
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e);
        }
    }

    default ChronoZonedDateTime<? extends ChronoLocalDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }

    default String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendChronologyText(textStyle).toFormatter(locale).format(new TemporalAccessor() { // from class: bytedance.jvm.time.chrono.Chronology.1
            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public boolean isSupported(TemporalField temporalField) {
                return false;
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public long getLong(TemporalField temporalField) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }

            @Override // bytedance.jvm.time.temporal.TemporalAccessor
            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.chronology()) {
                    return (R) Chronology.this;
                }
                return (R) super.query(temporalQuery);
            }
        });
    }

    default ChronoPeriod period(int i, int i2, int i3) {
        return new ChronoPeriodImpl(this, i, i2, i3);
    }

    default long epochSecond(int i, int i2, int i3, int i4, int i5, int i6, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "zoneOffset");
        ChronoField.HOUR_OF_DAY.checkValidValue(i4);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i5);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i6);
        return Math.addExact(UByte$.ExternalSyntheticBackport0.m$1(date(i, i2, i3).toEpochDay(), 86400), ((((i4 * 60) + i5) * 60) + i6) - zoneOffset.getTotalSeconds());
    }

    default long epochSecond(Era era, int i, int i2, int i3, int i4, int i5, int i6, ZoneOffset zoneOffset) {
        Objects.requireNonNull(era, "era");
        return epochSecond(prolepticYear(era, i), i2, i3, i4, i5, i6, zoneOffset);
    }
}
