package bytedance.jvm.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import bytedance.jvm.time.Clock;
import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.Month;
import bytedance.jvm.time.Period;
import bytedance.jvm.time.Year;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.ZonedDateTime;
import bytedance.jvm.time.format.ResolverStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class IsoChronology extends AbstractChronology implements Serializable {
    private static final long DAYS_0000_TO_1970 = 719528;
    public static final IsoChronology INSTANCE = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getId() {
        return ExifInterface.TAG_RW2_ISO;
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology
    /* bridge */ /* synthetic */ ChronoLocalDate resolveYMD(Map map, ResolverStyle resolverStyle) {
        return resolveYMD((Map<TemporalField, Long>) map, resolverStyle);
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology
    /* bridge */ /* synthetic */ ChronoLocalDate resolveYearOfEra(Map map, ResolverStyle resolverStyle) {
        return resolveYearOfEra((Map<TemporalField, Long>) map, resolverStyle);
    }

    private IsoChronology() {
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate date(Era era, int i, int i2, int i3) {
        return date(prolepticYear(era, i), i2, i3);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate date(int i, int i2, int i3) {
        return LocalDate.m87of(i, i2, i3);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate dateYearDay(Era era, int i, int i2) {
        return dateYearDay(prolepticYear(era, i), i2);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate dateYearDay(int i, int i2) {
        return LocalDate.ofYearDay(i, i2);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate dateEpochDay(long j) {
        return LocalDate.ofEpochDay(j);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate date(TemporalAccessor temporalAccessor) {
        return LocalDate.from(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public long epochSecond(int i, int i2, int i3, int i4, int i5, int i6, ZoneOffset zoneOffset) {
        long j;
        long j2 = i;
        ChronoField.YEAR.checkValidValue(j2);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
        ChronoField.DAY_OF_MONTH.checkValidValue(i3);
        ChronoField.HOUR_OF_DAY.checkValidValue(i4);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i5);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i6);
        Objects.requireNonNull(zoneOffset, "zoneOffset");
        if (i3 > 28 && i3 > numberOfDaysOfMonth(i, i2)) {
            if (i3 == 29) {
                throw new DateTimeException("Invalid date 'February 29' as '" + i + "' is not a leap year");
            }
            throw new DateTimeException("Invalid date '" + Month.m99of(i2).name() + " " + i3 + "'");
        }
        long j3 = (365 * j2) + 0;
        if (i >= 0) {
            j = j3 + (((3 + j2) / 4) - ((99 + j2) / 100)) + ((399 + j2) / 400);
        } else {
            j = j3 - (((i / (-4)) - (i / (-100))) + (i / (-400)));
        }
        long j4 = j + (((i2 * 367) - 362) / 12) + (i3 - 1);
        if (i2 > 2) {
            j4--;
            if (!INSTANCE.isLeapYear(j2)) {
                j4--;
            }
        }
        return Math.addExact(Math.multiplyExact(j4 - DAYS_0000_TO_1970, 86400L), ((((i4 * 60) + i5) * 60) + i6) - zoneOffset.getTotalSeconds());
    }

    private int numberOfDaysOfMonth(int i, int i2) {
        return i2 != 2 ? (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31 : INSTANCE.isLeapYear((long) i) ? 29 : 28;
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        return ZonedDateTime.from(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public LocalDate dateNow(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public boolean isLeapYear(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public int prolepticYear(Era era, int i) {
        if (era instanceof IsoEra) {
            return era == IsoEra.CE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public IsoEra eraOf(int i) {
        return IsoEra.m124of(i);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public List<Era> eras() {
        return UByte$.ExternalSyntheticBackport0.m(IsoEra.values());
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public LocalDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        return (LocalDate) super.resolveDate(map, resolverStyle);
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology
    void resolveProlepticMonth(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        Long remove = map.remove(ChronoField.PROLEPTIC_MONTH);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.PROLEPTIC_MONTH.checkValidValue(remove.longValue());
            }
            addFieldValue(map, ChronoField.MONTH_OF_YEAR, UByte$.ExternalSyntheticBackport0.m(remove.longValue(), 12) + 1);
            addFieldValue(map, ChronoField.YEAR, UByte$.ExternalSyntheticBackport0.m(remove.longValue(), 12));
        }
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology
    LocalDate resolveYearOfEra(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        Long remove = map.remove(ChronoField.YEAR_OF_ERA);
        if (remove != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                ChronoField.YEAR_OF_ERA.checkValidValue(remove.longValue());
            }
            Long remove2 = map.remove(ChronoField.ERA);
            if (remove2 != null) {
                if (remove2.longValue() == 1) {
                    addFieldValue(map, ChronoField.YEAR, remove.longValue());
                    return null;
                }
                if (remove2.longValue() == 0) {
                    addFieldValue(map, ChronoField.YEAR, Math.subtractExact(1L, remove.longValue()));
                    return null;
                }
                throw new DateTimeException("Invalid value for era: " + remove2);
            }
            Long l = map.get(ChronoField.YEAR);
            if (resolverStyle != ResolverStyle.STRICT) {
                addFieldValue(map, ChronoField.YEAR, (l == null || l.longValue() > 0) ? remove.longValue() : Math.subtractExact(1L, remove.longValue()));
                return null;
            }
            if (l != null) {
                addFieldValue(map, ChronoField.YEAR, l.longValue() > 0 ? remove.longValue() : Math.subtractExact(1L, remove.longValue()));
                return null;
            }
            map.put(ChronoField.YEAR_OF_ERA, remove);
            return null;
        }
        if (!map.containsKey(ChronoField.ERA)) {
            return null;
        }
        ChronoField.ERA.checkValidValue(map.get(ChronoField.ERA).longValue());
        return null;
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology
    LocalDate resolveYMD(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        int checkValidIntValue = ChronoField.YEAR.checkValidIntValue(map.remove(ChronoField.YEAR).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return LocalDate.m87of(checkValidIntValue, 1, 1).plusMonths(Math.subtractExact(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L)).plusDays(Math.subtractExact(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L));
        }
        int checkValidIntValue2 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(map.remove(ChronoField.MONTH_OF_YEAR).longValue());
        int checkValidIntValue3 = ChronoField.DAY_OF_MONTH.checkValidIntValue(map.remove(ChronoField.DAY_OF_MONTH).longValue());
        if (resolverStyle == ResolverStyle.SMART) {
            if (checkValidIntValue2 == 4 || checkValidIntValue2 == 6 || checkValidIntValue2 == 9 || checkValidIntValue2 == 11) {
                checkValidIntValue3 = Math.min(checkValidIntValue3, 30);
            } else if (checkValidIntValue2 == 2) {
                checkValidIntValue3 = Math.min(checkValidIntValue3, Month.FEBRUARY.length(Year.isLeap(checkValidIntValue)));
            }
        }
        return LocalDate.m87of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        return chronoField.range();
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public Period period(int i, int i2, int i3) {
        return Period.m107of(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.AbstractChronology
    public Object writeReplace() {
        return super.writeReplace();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
