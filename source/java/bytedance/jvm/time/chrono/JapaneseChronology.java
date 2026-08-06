package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.Year;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.format.ResolverStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjusters;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class JapaneseChronology extends AbstractChronology implements Serializable {
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getCalendarType() {
        return "japanese";
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public String getId() {
        return "Japanese";
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        return resolveDate((Map<TemporalField, Long>) map, resolverStyle);
    }

    private JapaneseChronology() {
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate date(Era era, int i, int i2, int i3) {
        if (!(era instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        return JapaneseDate.m126of((JapaneseEra) era, i, i2, i3);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate date(int i, int i2, int i3) {
        return new JapaneseDate(LocalDate.m87of(i, i2, i3));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate dateYearDay(Era era, int i, int i2) {
        return JapaneseDate.ofYearDay((JapaneseEra) era, i, i2);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate dateYearDay(int i, int i2) {
        return new JapaneseDate(LocalDate.ofYearDay(i, i2));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate dateEpochDay(long j) {
        return new JapaneseDate(LocalDate.ofEpochDay(j));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate dateNow(Clock clock) {
        return date((TemporalAccessor) LocalDate.now(clock));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseDate date(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof JapaneseDate) {
            return (JapaneseDate) temporalAccessor;
        }
        return new JapaneseDate(LocalDate.from(temporalAccessor));
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoLocalDateTime<JapaneseDate> localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(Instant instant, ZoneId zoneId) {
        return super.zonedDateTime(instant, zoneId);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public int prolepticYear(Era era, int i) {
        if (!(era instanceof JapaneseEra)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        JapaneseEra japaneseEra = (JapaneseEra) era;
        int year = (japaneseEra.getSince().getYear() + i) - 1;
        if (i == 1) {
            return year;
        }
        if (year < -999999999 || year > 999999999 || year < japaneseEra.getSince().getYear() || era != JapaneseEra.from(LocalDate.m87of(year, 1, 1))) {
            throw new DateTimeException("Invalid yearOfEra value");
        }
        return year;
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public JapaneseEra eraOf(int i) {
        return JapaneseEra.m127of(i);
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public List<Era> eras() {
        return UByte$.ExternalSyntheticBackport0.m(JapaneseEra.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.JapaneseChronology$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06381 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // bytedance.jvm.time.chrono.Chronology
    public ValueRange range(ChronoField chronoField) {
        switch (C06381.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + chronoField);
            case 5:
                return ValueRange.m135of(1L, JapaneseEra.shortestYearsOfEra(), Year.MAX_VALUE - JapaneseEra.getCurrentEra().getSince().getYear());
            case 6:
                return ValueRange.m135of(1L, JapaneseEra.shortestDaysOfYear(), ChronoField.DAY_OF_YEAR.range().getMaximum());
            case 7:
                return ValueRange.m134of(JapaneseDate.MEIJI_6_ISODATE.getYear(), 999999999L);
            case 8:
                return ValueRange.m134of(JapaneseEra.MEIJI.getValue(), JapaneseEra.getCurrentEra().getValue());
            default:
                return chronoField.range();
        }
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology, bytedance.jvm.time.chrono.Chronology
    public JapaneseDate resolveDate(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        return (JapaneseDate) super.resolveDate(map, resolverStyle);
    }

    @Override // bytedance.jvm.time.chrono.AbstractChronology
    ChronoLocalDate resolveYearOfEra(Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        Long l = map.get(ChronoField.ERA);
        JapaneseEra eraOf = l != null ? eraOf(range(ChronoField.ERA).checkValidIntValue(l.longValue(), ChronoField.ERA)) : null;
        Long l2 = map.get(ChronoField.YEAR_OF_ERA);
        int checkValidIntValue = l2 != null ? range(ChronoField.YEAR_OF_ERA).checkValidIntValue(l2.longValue(), ChronoField.YEAR_OF_ERA) : 0;
        if (eraOf == null && l2 != null && !map.containsKey(ChronoField.YEAR) && resolverStyle != ResolverStyle.STRICT) {
            eraOf = JapaneseEra.values()[JapaneseEra.values().length - 1];
        }
        if (l2 != null && eraOf != null) {
            if (map.containsKey(ChronoField.MONTH_OF_YEAR) && map.containsKey(ChronoField.DAY_OF_MONTH)) {
                return resolveYMD(eraOf, checkValidIntValue, map, resolverStyle);
            }
            if (map.containsKey(ChronoField.DAY_OF_YEAR)) {
                return resolveYD(eraOf, checkValidIntValue, map, resolverStyle);
            }
        }
        return null;
    }

    private int prolepticYearLenient(JapaneseEra japaneseEra, int i) {
        return (japaneseEra.getSince().getYear() + i) - 1;
    }

    private ChronoLocalDate resolveYMD(JapaneseEra japaneseEra, int i, Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        JapaneseDate with;
        map.remove(ChronoField.ERA);
        map.remove(ChronoField.YEAR_OF_ERA);
        if (resolverStyle == ResolverStyle.LENIENT) {
            int prolepticYearLenient = prolepticYearLenient(japaneseEra, i);
            return date(prolepticYearLenient, 1, 1).plus(Math.subtractExact(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(map.remove(ChronoField.DAY_OF_MONTH).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        int checkValidIntValue = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(map.remove(ChronoField.MONTH_OF_YEAR).longValue(), ChronoField.MONTH_OF_YEAR);
        int checkValidIntValue2 = range(ChronoField.DAY_OF_MONTH).checkValidIntValue(map.remove(ChronoField.DAY_OF_MONTH).longValue(), ChronoField.DAY_OF_MONTH);
        if (resolverStyle != ResolverStyle.SMART) {
            return date((Era) japaneseEra, i, checkValidIntValue, checkValidIntValue2);
        }
        if (i < 1) {
            throw new DateTimeException("Invalid YearOfEra: " + i);
        }
        int prolepticYearLenient2 = prolepticYearLenient(japaneseEra, i);
        try {
            with = date(prolepticYearLenient2, checkValidIntValue, checkValidIntValue2);
        } catch (DateTimeException unused) {
            with = date(prolepticYearLenient2, checkValidIntValue, 1).with(TemporalAdjusters.lastDayOfMonth());
        }
        if (with.getEra() == japaneseEra || with.get(ChronoField.YEAR_OF_ERA) <= 1 || i <= 1) {
            return with;
        }
        throw new DateTimeException("Invalid YearOfEra for Era: " + japaneseEra + " " + i);
    }

    private ChronoLocalDate resolveYD(JapaneseEra japaneseEra, int i, Map<TemporalField, Long> map, ResolverStyle resolverStyle) {
        map.remove(ChronoField.ERA);
        map.remove(ChronoField.YEAR_OF_ERA);
        if (resolverStyle == ResolverStyle.LENIENT) {
            int prolepticYearLenient = prolepticYearLenient(japaneseEra, i);
            return dateYearDay(prolepticYearLenient, 1).plus(Math.subtractExact(map.remove(ChronoField.DAY_OF_YEAR).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        return dateYearDay((Era) japaneseEra, i, range(ChronoField.DAY_OF_YEAR).checkValidIntValue(map.remove(ChronoField.DAY_OF_YEAR).longValue(), ChronoField.DAY_OF_YEAR));
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
