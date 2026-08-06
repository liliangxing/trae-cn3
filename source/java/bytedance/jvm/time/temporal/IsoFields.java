package bytedance.jvm.time.temporal;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.Duration;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;

    private IsoFields() {
        throw new AssertionError("Not instantiable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum Field implements TemporalField {
        DAY_OF_QUARTER { // from class: bytedance.jvm.time.temporal.IsoFields.Field.1
            @Override // java.lang.Enum, bytedance.jvm.time.temporal.TemporalField
            public String toString() {
                return "DayOfQuarter";
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return ChronoUnit.DAYS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.m135of(1L, 90L, 92L);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && IsoFields.isIso(temporalAccessor);
            }

            @Override // bytedance.jvm.time.temporal.IsoFields.Field, bytedance.jvm.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j = temporalAccessor.getLong(QUARTER_OF_YEAR);
                if (j == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.m134of(1L, 91L) : ValueRange.m134of(1L, 90L);
                }
                if (j == 2) {
                    return ValueRange.m134of(1L, 91L);
                }
                if (j == 3 || j == 4) {
                    return ValueRange.m134of(1L, 92L);
                }
                return range();
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                long from = getFrom(r);
                range().checkValidValue(j, this);
                return (R) r.with(ChronoField.DAY_OF_YEAR, r.getLong(ChronoField.DAY_OF_YEAR) + (j - from));
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate m87of;
                long j;
                Long l = map.get(ChronoField.YEAR);
                Long l2 = map.get(QUARTER_OF_YEAR);
                if (l == null || l2 == null) {
                    return null;
                }
                int checkValidIntValue = ChronoField.YEAR.checkValidIntValue(l.longValue());
                long longValue = map.get(DAY_OF_QUARTER).longValue();
                Field.ensureIso(temporalAccessor);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    m87of = LocalDate.m87of(checkValidIntValue, 1, 1).plusMonths(UByte$.ExternalSyntheticBackport0.m$1(Math.subtractExact(l2.longValue(), 1L), 3));
                    j = Math.subtractExact(longValue, 1L);
                } else {
                    m87of = LocalDate.m87of(checkValidIntValue, ((QUARTER_OF_YEAR.range().checkValidIntValue(l2.longValue(), QUARTER_OF_YEAR) - 1) * 3) + 1, 1);
                    if (longValue < 1 || longValue > 90) {
                        if (resolverStyle == ResolverStyle.STRICT) {
                            rangeRefinedBy(m87of).checkValidValue(longValue, this);
                        } else {
                            range().checkValidValue(longValue, this);
                        }
                    }
                    j = longValue - 1;
                }
                map.remove(this);
                map.remove(ChronoField.YEAR);
                map.remove(QUARTER_OF_YEAR);
                return m87of.plusDays(j);
            }
        },
        QUARTER_OF_YEAR { // from class: bytedance.jvm.time.temporal.IsoFields.Field.2
            @Override // java.lang.Enum, bytedance.jvm.time.temporal.TemporalField
            public String toString() {
                return "QuarterOfYear";
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return ChronoUnit.YEARS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.m134of(1L, 4L);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && IsoFields.isIso(temporalAccessor);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // bytedance.jvm.time.temporal.IsoFields.Field, bytedance.jvm.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }
                return super.rangeRefinedBy(temporalAccessor);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                long from = getFrom(r);
                range().checkValidValue(j, this);
                return (R) r.with(ChronoField.MONTH_OF_YEAR, r.getLong(ChronoField.MONTH_OF_YEAR) + ((j - from) * 3));
            }
        },
        WEEK_OF_WEEK_BASED_YEAR { // from class: bytedance.jvm.time.temporal.IsoFields.Field.3
            @Override // java.lang.Enum, bytedance.jvm.time.temporal.TemporalField
            public String toString() {
                return "WeekOfWeekBasedYear";
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public String getDisplayName(Locale locale) {
                Objects.requireNonNull(locale, "locale");
                return "Week";
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return ChronoUnit.WEEKS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.m135of(1L, 52L, 53L);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporalAccessor);
            }

            @Override // bytedance.jvm.time.temporal.IsoFields.Field, bytedance.jvm.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.getWeekRange(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.getWeek(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                range().checkValidValue(j, this);
                return (R) r.plus(Math.subtractExact(j, getFrom(r)), ChronoUnit.WEEKS);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate with;
                long j;
                Long l = map.get(WEEK_BASED_YEAR);
                Long l2 = map.get(ChronoField.DAY_OF_WEEK);
                if (l == null || l2 == null) {
                    return null;
                }
                int checkValidIntValue = WEEK_BASED_YEAR.range().checkValidIntValue(l.longValue(), WEEK_BASED_YEAR);
                long longValue = map.get(WEEK_OF_WEEK_BASED_YEAR).longValue();
                Field.ensureIso(temporalAccessor);
                LocalDate m87of = LocalDate.m87of(checkValidIntValue, 1, 4);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long longValue2 = l2.longValue();
                    if (longValue2 > 7) {
                        long j2 = longValue2 - 1;
                        m87of = m87of.plusWeeks(j2 / 7);
                        j = j2 % 7;
                    } else {
                        if (longValue2 < 1) {
                            m87of = m87of.plusWeeks(Math.subtractExact(longValue2, 7L) / 7);
                            j = (longValue2 + 6) % 7;
                        }
                        with = m87of.plusWeeks(Math.subtractExact(longValue, 1L)).with((TemporalField) ChronoField.DAY_OF_WEEK, longValue2);
                    }
                    longValue2 = j + 1;
                    with = m87of.plusWeeks(Math.subtractExact(longValue, 1L)).with((TemporalField) ChronoField.DAY_OF_WEEK, longValue2);
                } else {
                    int checkValidIntValue2 = ChronoField.DAY_OF_WEEK.checkValidIntValue(l2.longValue());
                    if (longValue < 1 || longValue > 52) {
                        if (resolverStyle == ResolverStyle.STRICT) {
                            Field.getWeekRange(m87of).checkValidValue(longValue, this);
                        } else {
                            range().checkValidValue(longValue, this);
                        }
                    }
                    with = m87of.plusWeeks(longValue - 1).with((TemporalField) ChronoField.DAY_OF_WEEK, checkValidIntValue2);
                }
                map.remove(this);
                map.remove(WEEK_BASED_YEAR);
                map.remove(ChronoField.DAY_OF_WEEK);
                return with;
            }
        },
        WEEK_BASED_YEAR { // from class: bytedance.jvm.time.temporal.IsoFields.Field.4
            @Override // java.lang.Enum, bytedance.jvm.time.temporal.TemporalField
            public String toString() {
                return "WeekBasedYear";
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return ChronoUnit.FOREVER;
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporalAccessor);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // bytedance.jvm.time.temporal.IsoFields.Field, bytedance.jvm.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                return super.rangeRefinedBy(temporalAccessor);
            }

            @Override // bytedance.jvm.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r, long j) {
                if (!isSupportedBy(r)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int checkValidIntValue = range().checkValidIntValue(j, WEEK_BASED_YEAR);
                LocalDate from = LocalDate.from((TemporalAccessor) r);
                int i = from.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(from);
                if (week == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                    week = 52;
                }
                return (R) r.with(LocalDate.m87of(checkValidIntValue, 1, 4).plusDays((i - r5.get(ChronoField.DAY_OF_WEEK)) + ((week - 1) * 7)));
            }
        };

        private static final int[] QUARTER_DAYS = {0, 90, 181, 273, 0, 91, 182, 274};

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        /* synthetic */ Field(C06511 c06511) {
            this();
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            return range();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void ensureIso(TemporalAccessor temporalAccessor) {
            if (!IsoFields.isIso(temporalAccessor)) {
                throw new DateTimeException("Resolve requires IsoChronology");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.m134of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int i) {
            LocalDate m87of = LocalDate.m87of(i, 1, 1);
            if (m87of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (m87of.getDayOfWeek() == DayOfWeek.WEDNESDAY && m87of.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeek(LocalDate localDate) {
            int ordinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i = (3 - ordinal) + dayOfYear;
            int i2 = (i - ((i / 7) * 7)) - 3;
            if (i2 < -3) {
                i2 += 7;
            }
            if (dayOfYear < i2) {
                return (int) getWeekRange(localDate.withDayOfYear(180).minusYears(1L)).getMaximum();
            }
            int i3 = ((dayOfYear - i2) / 7) + 1;
            if (i3 == 53) {
                if (!(i2 == -3 || (i2 == -2 && localDate.isLeapYear()))) {
                    return 1;
                }
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            }
            return year;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        Unit(String str, Duration duration) {
            this.name = str;
            this.duration = duration;
        }

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public Duration getDuration() {
            return this.duration;
        }

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public boolean isSupportedBy(Temporal temporal) {
            return temporal.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporal);
        }

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r, long j) {
            int i = C06511.$SwitchMap$bytedance$jvm$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                return (R) r.with(IsoFields.WEEK_BASED_YEAR, Math.addExact(r.get(IsoFields.WEEK_BASED_YEAR), j));
            }
            if (i == 2) {
                return (R) r.plus(j / 4, ChronoUnit.YEARS).plus((j % 4) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // bytedance.jvm.time.temporal.TemporalUnit
        public long between(Temporal temporal, Temporal temporal2) {
            if (temporal.getClass() != temporal2.getClass()) {
                return temporal.until(temporal2, this);
            }
            int i = C06511.$SwitchMap$bytedance$jvm$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                return Math.subtractExact(temporal2.getLong(IsoFields.WEEK_BASED_YEAR), temporal.getLong(IsoFields.WEEK_BASED_YEAR));
            }
            if (i == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // java.lang.Enum, bytedance.jvm.time.temporal.TemporalUnit
        public String toString() {
            return this.name;
        }
    }

    /* renamed from: bytedance.jvm.time.temporal.IsoFields$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static /* synthetic */ class C06511 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$IsoFields$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$IsoFields$Unit = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static boolean isIso(TemporalAccessor temporalAccessor) {
        return Chronology.from(temporalAccessor).equals(IsoChronology.INSTANCE);
    }
}
