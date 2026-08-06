package bytedance.jvm.time.temporal;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.format.ResolverStyle;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = m137of(DayOfWeek.SUNDAY, 1);
    public static final TemporalUnit WEEK_BASED_YEARS = IsoFields.WEEK_BASED_YEARS;
    private static final long serialVersionUID = -1177360819670808121L;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
    private final transient TemporalField weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
    private final transient TemporalField weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
    private final transient TemporalField weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);

    /* renamed from: of */
    public static WeekFields m138of(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        return m137of(DayOfWeek.SUNDAY.plus(r4.getFirstDayOfWeek() - 1), Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
    }

    /* renamed from: of */
    public static WeekFields m137of(DayOfWeek dayOfWeek, int i) {
        String str = dayOfWeek.toString() + i;
        ConcurrentMap<String, WeekFields> concurrentMap = CACHE;
        WeekFields weekFields = concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, i));
        return concurrentMap.get(str);
    }

    private WeekFields(DayOfWeek dayOfWeek, int i) {
        Objects.requireNonNull(dayOfWeek, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek;
        this.minimalDays = i;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException, InvalidObjectException {
        objectInputStream.defaultReadObject();
        if (this.firstDayOfWeek == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i = this.minimalDays;
        if (i < 1 || i > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return m137of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException("Invalid serialized WeekFields: " + e.getMessage());
        }
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + ',' + this.minimalDays + ']';
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static class ComputedDayOfField implements TemporalField {
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.m134of(1, 7);
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.m136of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.m136of(0, 1, 52, 54);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.m135of(1, 52, 53);

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, ChronoField.YEAR.range());
        }

        private ChronoLocalDate ofWeekBasedYear(Chronology chronology, int i, int i2, int i3) {
            ChronoLocalDate date = chronology.date(i, 1, 1);
            int startOfWeekOffset = startOfWeekOffset(1, localizedDayOfWeek(date));
            return date.plus((-startOfWeekOffset) + (i3 - 1) + ((Math.min(i2, computeWeek(startOfWeekOffset, date.lengthOfYear() + this.weekDef.getMinimalDaysInFirstWeek()) - 1) - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
        }

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.name = str;
            this.weekDef = weekFields;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = valueRange;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public long getFrom(TemporalAccessor temporalAccessor) {
            int localizedWeekBasedYear;
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                localizedWeekBasedYear = localizedDayOfWeek(temporalAccessor);
            } else {
                if (this.rangeUnit == ChronoUnit.MONTHS) {
                    return localizedWeekOfMonth(temporalAccessor);
                }
                if (this.rangeUnit == ChronoUnit.YEARS) {
                    return localizedWeekOfYear(temporalAccessor);
                }
                if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS) {
                    localizedWeekBasedYear = localizedWeekOfWeekBasedYear(temporalAccessor);
                } else if (this.rangeUnit == ChronoUnit.FOREVER) {
                    localizedWeekBasedYear = localizedWeekBasedYear(temporalAccessor);
                } else {
                    throw new IllegalStateException("unreachable, rangeUnit: " + this.rangeUnit + ", this: " + this);
                }
            }
            return localizedWeekBasedYear;
        }

        private int localizedDayOfWeek(TemporalAccessor temporalAccessor) {
            return Math.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private int localizedDayOfWeek(int i) {
            return Math.floorMod(i - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            return computeWeek(startOfWeekOffset(i, localizedDayOfWeek), i);
        }

        private long localizedWeekOfYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            return computeWeek(startOfWeekOffset(i, localizedDayOfWeek), i);
        }

        private int localizedWeekBasedYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.YEAR);
            int i2 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            int startOfWeekOffset = startOfWeekOffset(i2, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i2);
            return computeWeek == 0 ? i - 1 : computeWeek >= computeWeek(startOfWeekOffset, ((int) temporalAccessor.range(ChronoField.DAY_OF_YEAR).getMaximum()) + this.weekDef.getMinimalDaysInFirstWeek()) ? i + 1 : i;
        }

        private int localizedWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            int computeWeek;
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            int startOfWeekOffset = startOfWeekOffset(i, localizedDayOfWeek);
            int computeWeek2 = computeWeek(startOfWeekOffset, i);
            if (computeWeek2 == 0) {
                return localizedWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(i, (TemporalUnit) ChronoUnit.DAYS));
            }
            return (computeWeek2 <= 50 || computeWeek2 < (computeWeek = computeWeek(startOfWeekOffset, ((int) temporalAccessor.range(ChronoField.DAY_OF_YEAR).getMaximum()) + this.weekDef.getMinimalDaysInFirstWeek()))) ? computeWeek2 : (computeWeek2 - computeWeek) + 1;
        }

        private int startOfWeekOffset(int i, int i2) {
            int floorMod = Math.floorMod(i - i2, 7);
            return floorMod + 1 > this.weekDef.getMinimalDaysInFirstWeek() ? 7 - floorMod : -floorMod;
        }

        private int computeWeek(int i, int i2) {
            return ((i + 7) + (i2 - 1)) / 7;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r, long j) {
            if (this.range.checkValidIntValue(j, this) == r.get(this)) {
                return r;
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return ofWeekBasedYear(Chronology.from(r), (int) j, r.get(this.weekDef.weekOfWeekBasedYear), r.get(this.weekDef.dayOfWeek));
            }
            return (R) r.plus(r0 - r1, this.baseUnit);
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ChronoLocalDate resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            int intExact = Math.toIntExact(map.get(this).longValue());
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                long floorMod = Math.floorMod((this.weekDef.getFirstDayOfWeek().getValue() - 1) + (this.range.checkValidIntValue(r2, this) - 1), 7) + 1;
                map.remove(this);
                map.put(ChronoField.DAY_OF_WEEK, Long.valueOf(floorMod));
                return null;
            }
            if (!map.containsKey(ChronoField.DAY_OF_WEEK)) {
                return null;
            }
            int localizedDayOfWeek = localizedDayOfWeek(ChronoField.DAY_OF_WEEK.checkValidIntValue(map.get(ChronoField.DAY_OF_WEEK).longValue()));
            Chronology from = Chronology.from(temporalAccessor);
            if (map.containsKey(ChronoField.YEAR)) {
                int checkValidIntValue = ChronoField.YEAR.checkValidIntValue(map.get(ChronoField.YEAR).longValue());
                if (this.rangeUnit == ChronoUnit.MONTHS && map.containsKey(ChronoField.MONTH_OF_YEAR)) {
                    return resolveWoM(map, from, checkValidIntValue, map.get(ChronoField.MONTH_OF_YEAR).longValue(), intExact, localizedDayOfWeek, resolverStyle);
                }
                if (this.rangeUnit == ChronoUnit.YEARS) {
                    return resolveWoY(map, from, checkValidIntValue, intExact, localizedDayOfWeek, resolverStyle);
                }
            } else if ((this.rangeUnit == WeekFields.WEEK_BASED_YEARS || this.rangeUnit == ChronoUnit.FOREVER) && map.containsKey(this.weekDef.weekBasedYear) && map.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                return resolveWBY(map, from, localizedDayOfWeek, resolverStyle);
            }
            return null;
        }

        private ChronoLocalDate resolveWoM(Map<TemporalField, Long> map, Chronology chronology, int i, long j, long j2, int i2, ResolverStyle resolverStyle) {
            ChronoLocalDate plus;
            if (resolverStyle == ResolverStyle.LENIENT) {
                ChronoLocalDate plus2 = chronology.date(i, 1, 1).plus(Math.subtractExact(j, 1L), (TemporalUnit) ChronoUnit.MONTHS);
                plus = plus2.plus(Math.addExact(UByte$.ExternalSyntheticBackport0.m$1(Math.subtractExact(j2, localizedWeekOfMonth(plus2)), 7), i2 - localizedDayOfWeek(plus2)), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                plus = chronology.date(i, ChronoField.MONTH_OF_YEAR.checkValidIntValue(j), 1).plus((((int) (this.range.checkValidIntValue(j2, this) - localizedWeekOfMonth(r6))) * 7) + (i2 - localizedDayOfWeek(r6)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(ChronoField.MONTH_OF_YEAR) != j) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                }
            }
            map.remove(this);
            map.remove(ChronoField.YEAR);
            map.remove(ChronoField.MONTH_OF_YEAR);
            map.remove(ChronoField.DAY_OF_WEEK);
            return plus;
        }

        private ChronoLocalDate resolveWoY(Map<TemporalField, Long> map, Chronology chronology, int i, long j, int i2, ResolverStyle resolverStyle) {
            ChronoLocalDate plus;
            ChronoLocalDate date = chronology.date(i, 1, 1);
            if (resolverStyle == ResolverStyle.LENIENT) {
                plus = date.plus(Math.addExact(UByte$.ExternalSyntheticBackport0.m$1(Math.subtractExact(j, localizedWeekOfYear(date)), 7), i2 - localizedDayOfWeek(date)), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                plus = date.plus((((int) (this.range.checkValidIntValue(j, this) - localizedWeekOfYear(date))) * 7) + (i2 - localizedDayOfWeek(date)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(ChronoField.YEAR) != i) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                }
            }
            map.remove(this);
            map.remove(ChronoField.YEAR);
            map.remove(ChronoField.DAY_OF_WEEK);
            return plus;
        }

        private ChronoLocalDate resolveWBY(Map<TemporalField, Long> map, Chronology chronology, int i, ResolverStyle resolverStyle) {
            ChronoLocalDate ofWeekBasedYear;
            int checkValidIntValue = this.weekDef.weekBasedYear.range().checkValidIntValue(map.get(this.weekDef.weekBasedYear).longValue(), this.weekDef.weekBasedYear);
            if (resolverStyle == ResolverStyle.LENIENT) {
                ofWeekBasedYear = ofWeekBasedYear(chronology, checkValidIntValue, 1, i).plus(Math.subtractExact(map.get(this.weekDef.weekOfWeekBasedYear).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS);
            } else {
                ofWeekBasedYear = ofWeekBasedYear(chronology, checkValidIntValue, this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(map.get(this.weekDef.weekOfWeekBasedYear).longValue(), this.weekDef.weekOfWeekBasedYear), i);
                if (resolverStyle == ResolverStyle.STRICT && localizedWeekBasedYear(ofWeekBasedYear) != checkValidIntValue) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different week-based-year");
                }
            }
            map.remove(this);
            map.remove(this.weekDef.weekBasedYear);
            map.remove(this.weekDef.weekOfWeekBasedYear);
            map.remove(ChronoField.DAY_OF_WEEK);
            return ofWeekBasedYear;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public String getDisplayName(Locale locale) {
            Objects.requireNonNull(locale, "locale");
            return this.rangeUnit == ChronoUnit.YEARS ? "Week" : this.name;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (this.rangeUnit == ChronoUnit.MONTHS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_MONTH);
            }
            if (this.rangeUnit == ChronoUnit.YEARS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return temporalAccessor.isSupported(ChronoField.YEAR);
            }
            return false;
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (this.rangeUnit == ChronoUnit.MONTHS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_MONTH);
            }
            if (this.rangeUnit == ChronoUnit.YEARS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_YEAR);
            }
            if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS) {
                return rangeWeekOfWeekBasedYear(temporalAccessor);
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return ChronoField.YEAR.range();
            }
            throw new IllegalStateException("unreachable, rangeUnit: " + this.rangeUnit + ", this: " + this);
        }

        private ValueRange rangeByWeek(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(temporalField), localizedDayOfWeek(temporalAccessor));
            ValueRange range = temporalAccessor.range(temporalField);
            return ValueRange.m134of(computeWeek(startOfWeekOffset, (int) range.getMinimum()), computeWeek(startOfWeekOffset, (int) range.getMaximum()));
        }

        private ValueRange rangeWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR)) {
                return WEEK_OF_YEAR_RANGE;
            }
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int i = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            int startOfWeekOffset = startOfWeekOffset(i, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, i);
            if (computeWeek == 0) {
                return rangeWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(i + 7, (TemporalUnit) ChronoUnit.DAYS));
            }
            if (computeWeek >= computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(ChronoField.DAY_OF_YEAR).getMaximum()))) {
                return rangeWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).plus((r3 - i) + 1 + 7, (TemporalUnit) ChronoUnit.DAYS));
            }
            return ValueRange.m134of(1L, r0 - 1);
        }

        @Override // bytedance.jvm.time.temporal.TemporalField
        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }
}
