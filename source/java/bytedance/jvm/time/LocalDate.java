package bytedance.jvm.time;

import androidx.core.location.LocationRequestCompat;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.chrono.IsoEra;
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
import bytedance.jvm.time.zone.ZoneOffsetTransition;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.LongFunction;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LocalDate implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = m87of(Year.MIN_VALUE, 1, 1);
    public static final LocalDate MAX = m87of(Year.MAX_VALUE, 12, 31);
    public static final LocalDate EPOCH = m87of(1970, 1, 1);

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDate now(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        return ofInstant(clock.instant(), clock.getZone());
    }

    /* renamed from: of */
    public static LocalDate m88of(int i, Month month, int i2) {
        ChronoField.YEAR.checkValidValue(i);
        Objects.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i2);
        return create(i, month.getValue(), i2);
    }

    /* renamed from: of */
    public static LocalDate m87of(int i, int i2, int i3) {
        ChronoField.YEAR.checkValidValue(i);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
        ChronoField.DAY_OF_MONTH.checkValidValue(i3);
        return create(i, i2, i3);
    }

    public static LocalDate ofYearDay(int i, int i2) {
        long j = i;
        ChronoField.YEAR.checkValidValue(j);
        ChronoField.DAY_OF_YEAR.checkValidValue(i2);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j);
        if (i2 == 366 && !isLeapYear) {
            throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i + "' is not a leap year");
        }
        Month m99of = Month.m99of(((i2 - 1) / 31) + 1);
        if (i2 > (m99of.firstDayOfYear(isLeapYear) + m99of.length(isLeapYear)) - 1) {
            m99of = m99of.plus(1L);
        }
        return new LocalDate(i, m99of.getValue(), (i2 - m99of.firstDayOfYear(isLeapYear)) + 1);
    }

    public static LocalDate ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ofEpochDay(UByte$.ExternalSyntheticBackport0.m(instant.getEpochSecond() + zoneId.getRules().getOffset(instant).getTotalSeconds(), 86400));
    }

    public static LocalDate ofEpochDay(long j) {
        long j2;
        ChronoField.EPOCH_DAY.checkValidValue(j);
        long j3 = (j + DAYS_0000_TO_1970) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((((j5 * 365) + (j5 / 4)) - (j5 / 100)) + (j5 / 400));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((((365 * j5) + (j5 / 4)) - (j5 / 100)) + (j5 / 400));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j5 + j2 + (i2 / 10)), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static LocalDate parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: bytedance.jvm.time.LocalDate$$ExternalSyntheticLambda2
            @Override // bytedance.jvm.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDate.from(temporalAccessor);
            }
        });
    }

    private static LocalDate create(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (IsoChronology.INSTANCE.isLeapYear(i)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                throw new DateTimeException("Invalid date '" + Month.m99of(i2).name() + " " + i3 + "'");
            }
        }
        return new LocalDate(i, i2, i3);
    }

    private static LocalDate resolvePreviousValid(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, IsoChronology.INSTANCE.isLeapYear((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new LocalDate(i, i2, i3);
    }

    private LocalDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (short) i2;
        this.day = (short) i3;
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public boolean isSupported(TemporalUnit temporalUnit) {
        return super.isSupported(temporalUnit);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            if (chronoField.isDateBased()) {
                int i = C06201.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
                if (i == 1) {
                    return ValueRange.m134of(1L, lengthOfMonth());
                }
                if (i == 2) {
                    return ValueRange.m134of(1L, lengthOfYear());
                }
                if (i == 3) {
                    return ValueRange.m134of(1L, (getMonth() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
                }
                if (i != 4) {
                    return temporalField.range();
                }
                return ValueRange.m134of(1L, getYear() <= 0 ? 1000000000L : 999999999L);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return get0(temporalField);
        }
        return super.get(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.EPOCH_DAY) {
                return toEpochDay();
            }
            if (temporalField == ChronoField.PROLEPTIC_MONTH) {
                return getProlepticMonth();
            }
            return get0(temporalField);
        }
        return temporalField.getFrom(this);
    }

    private int get0(TemporalField temporalField) {
        switch (C06201.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i = this.year;
                return i >= 1 ? i : 1 - i;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new UnsupportedTemporalTypeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new UnsupportedTemporalTypeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long getProlepticMonth() {
        return ((this.year * 12) + this.month) - 1;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public IsoEra getEra() {
        return getYear() >= 1 ? IsoEra.CE : IsoEra.BCE;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonthValue() {
        return this.month;
    }

    public Month getMonth() {
        return Month.m99of(this.month);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.m85of(UByte$.ExternalSyntheticBackport0.m(toEpochDay() + 3, 7) + 1);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        short s = this.month;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.adjustInto(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public LocalDate with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j);
            switch (C06201.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return withDayOfMonth((int) j);
                case 2:
                    return withDayOfYear((int) j);
                case 3:
                    return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.year < 1) {
                        j = 1 - j;
                    }
                    return withYear((int) j);
                case 5:
                    return plusDays(j - getDayOfWeek().getValue());
                case 6:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return ofEpochDay(j);
                case 9:
                    return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    return withMonth((int) j);
                case 11:
                    return plusMonths(j - getProlepticMonth());
                case 12:
                    return withYear((int) j);
                case 13:
                    return getLong(ChronoField.ERA) == j ? this : withYear(1 - this.year);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (LocalDate) temporalField.adjustInto(this, j);
    }

    public LocalDate withYear(int i) {
        if (this.year == i) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(i);
        return resolvePreviousValid(i, this.month, this.day);
    }

    public LocalDate withMonth(int i) {
        if (this.month == i) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue(i);
        return resolvePreviousValid(this.year, i, this.day);
    }

    public LocalDate withDayOfMonth(int i) {
        return this.day == i ? this : m87of(this.year, this.month, i);
    }

    public LocalDate withDayOfYear(int i) {
        return getDayOfYear() == i ? this : ofYearDay(this.year, i);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public LocalDate plus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return plusMonths(((Period) temporalAmount).toTotalMonths()).plusDays(r4.getDays());
        }
        Objects.requireNonNull(temporalAmount, "amountToAdd");
        return (LocalDate) temporalAmount.addTo(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public LocalDate plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (C06201.$SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j);
                case 2:
                    return plusWeeks(j);
                case 3:
                    return plusMonths(j);
                case 4:
                    return plusYears(j);
                case 5:
                    return plusYears(UByte$.ExternalSyntheticBackport0.m$1(j, 10));
                case 6:
                    return plusYears(UByte$.ExternalSyntheticBackport0.m$1(j, 100));
                case 7:
                    return plusYears(UByte$.ExternalSyntheticBackport0.m$1(j, 1000));
                case 8:
                    return with((TemporalField) ChronoField.ERA, Math.addExact(getLong(ChronoField.ERA), j));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return (LocalDate) temporalUnit.addTo(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.LocalDate$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06201 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    public LocalDate plusYears(long j) {
        return j == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(this.year + j), this.month, this.day);
    }

    public LocalDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.year * 12) + (this.month - 1) + j;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(UByte$.ExternalSyntheticBackport0.m(j2, 12)), UByte$.ExternalSyntheticBackport0.m(j2, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j) {
        return plusDays(UByte$.ExternalSyntheticBackport0.m$1(j, 7));
    }

    public LocalDate plusDays(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.day + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new LocalDate(this.year, this.month, (int) j2);
            }
            if (j2 <= 59) {
                long lengthOfMonth = lengthOfMonth();
                if (j2 <= lengthOfMonth) {
                    return new LocalDate(this.year, this.month, (int) j2);
                }
                short s = this.month;
                if (s < 12) {
                    return new LocalDate(this.year, s + 1, (int) (j2 - lengthOfMonth));
                }
                ChronoField.YEAR.checkValidValue(this.year + 1);
                return new LocalDate(this.year + 1, 1, (int) (j2 - lengthOfMonth));
            }
        }
        return ofEpochDay(Math.addExact(toEpochDay(), j));
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public LocalDate minus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return minusMonths(((Period) temporalAmount).toTotalMonths()).minusDays(r4.getDays());
        }
        Objects.requireNonNull(temporalAmount, "amountToSubtract");
        return (LocalDate) temporalAmount.subtractFrom(this);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public LocalDate minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(LocationRequestCompat.PASSIVE_INTERVAL, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public LocalDate minusYears(long j) {
        return j == Long.MIN_VALUE ? plusYears(LocationRequestCompat.PASSIVE_INTERVAL).plusYears(1L) : plusYears(-j);
    }

    public LocalDate minusMonths(long j) {
        return j == Long.MIN_VALUE ? plusMonths(LocationRequestCompat.PASSIVE_INTERVAL).plusMonths(1L) : plusMonths(-j);
    }

    public LocalDate minusWeeks(long j) {
        return j == Long.MIN_VALUE ? plusWeeks(LocationRequestCompat.PASSIVE_INTERVAL).plusWeeks(1L) : plusWeeks(-j);
    }

    public LocalDate minusDays(long j) {
        return j == Long.MIN_VALUE ? plusDays(LocationRequestCompat.PASSIVE_INTERVAL).plusDays(1L) : plusDays(-j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? this : (R) super.query(temporalQuery);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    @Override // bytedance.jvm.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate from = from((TemporalAccessor) temporal);
        if (temporalUnit instanceof ChronoUnit) {
            switch (C06201.$SwitchMap$bytedance$jvm$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return daysUntil(from);
                case 2:
                    return daysUntil(from) / 7;
                case 3:
                    return monthsUntil(from);
                case 4:
                    return monthsUntil(from) / 12;
                case 5:
                    return monthsUntil(from) / 120;
                case 6:
                    return monthsUntil(from) / MonitorConstants.FETCH_SETTING_INTERVAL;
                case 7:
                    return monthsUntil(from) / 12000;
                case 8:
                    return from.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        }
        return temporalUnit.between(this, from);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long daysUntil(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + localDate.getDayOfMonth()) - ((getProlepticMonth() * 32) + getDayOfMonth())) / 32;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public Period until(ChronoLocalDate chronoLocalDate) {
        LocalDate from = from((TemporalAccessor) chronoLocalDate);
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        int i = from.day - this.day;
        if (prolepticMonth > 0 && i < 0) {
            prolepticMonth--;
            i = (int) (from.toEpochDay() - plusMonths(prolepticMonth).toEpochDay());
        } else if (prolepticMonth < 0 && i > 0) {
            prolepticMonth++;
            i -= from.lengthOfMonth();
        }
        return Period.m107of(Math.toIntExact(prolepticMonth / 12), (int) (prolepticMonth % 12), i);
    }

    public Stream<LocalDate> datesUntil(LocalDate localDate) {
        long epochDay = localDate.toEpochDay();
        long epochDay2 = toEpochDay();
        if (epochDay < epochDay2) {
            throw new IllegalArgumentException(localDate + " < " + this);
        }
        return LongStream.range(epochDay2, epochDay).mapToObj(new DesugarLocalDate$$ExternalSyntheticLambda1());
    }

    public Stream<LocalDate> datesUntil(LocalDate localDate, Period period) {
        long prolepticMonth;
        long prolepticMonth2;
        if (period.isZero()) {
            throw new IllegalArgumentException("step is zero");
        }
        long epochDay = localDate.toEpochDay();
        final long epochDay2 = toEpochDay();
        long j = epochDay - epochDay2;
        final long totalMonths = period.toTotalMonths();
        final long days = period.getDays();
        if ((totalMonths < 0 && days > 0) || (totalMonths > 0 && days < 0)) {
            throw new IllegalArgumentException("period months and days are of opposite sign");
        }
        if (j == 0) {
            return Stream.empty();
        }
        int i = (totalMonths > 0 || days > 0) ? 1 : -1;
        if ((i < 0) ^ (j < 0)) {
            throw new IllegalArgumentException(localDate + (i < 0 ? " > " : " < ") + this);
        }
        if (totalMonths == 0) {
            return LongStream.rangeClosed(0L, (j - i) / days).mapToObj(new LongFunction() { // from class: bytedance.jvm.time.LocalDate$$ExternalSyntheticLambda0
                @Override // java.util.function.LongFunction
                public final Object apply(long j2) {
                    LocalDate ofEpochDay;
                    ofEpochDay = LocalDate.ofEpochDay(epochDay2 + (j2 * days));
                    return ofEpochDay;
                }
            });
        }
        long j2 = ((j * 1600) / ((48699 * totalMonths) + (1600 * days))) + 1;
        long j3 = totalMonths * j2;
        long j4 = days * j2;
        if (totalMonths > 0) {
            prolepticMonth = MAX.getProlepticMonth();
            prolepticMonth2 = getProlepticMonth();
        } else {
            prolepticMonth = getProlepticMonth();
            prolepticMonth2 = MIN.getProlepticMonth();
        }
        long j5 = prolepticMonth - prolepticMonth2;
        long j6 = i;
        if (j3 * j6 > j5 || (plusMonths(j3).toEpochDay() + j4) * j6 >= epochDay * j6) {
            j2--;
            long j7 = j3 - totalMonths;
            long j8 = j4 - days;
            if (j7 * j6 > j5 || (plusMonths(j7).toEpochDay() + j8) * j6 >= epochDay * j6) {
                j2--;
            }
        }
        return LongStream.rangeClosed(0L, j2).mapToObj(new LongFunction() { // from class: bytedance.jvm.time.LocalDate$$ExternalSyntheticLambda1
            @Override // java.util.function.LongFunction
            public final Object apply(long j9) {
                return LocalDate.this.m3170lambda$datesUntil$1$bytedancejvmtimeLocalDate(totalMonths, days, j9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$datesUntil$1$bytedance-jvm-time-LocalDate, reason: not valid java name */
    public /* synthetic */ LocalDate m3170lambda$datesUntil$1$bytedancejvmtimeLocalDate(long j, long j2, long j3) {
        return plusMonths(j * j3).plusDays(j2 * j3);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.m95of(this, localTime);
    }

    public LocalDateTime atTime(int i, int i2) {
        return atTime(LocalTime.m96of(i, i2));
    }

    public LocalDateTime atTime(int i, int i2, int i3) {
        return atTime(LocalTime.m97of(i, i2, i3));
    }

    public LocalDateTime atTime(int i, int i2, int i3, int i4) {
        return atTime(LocalTime.m98of(i, i2, i3, i4));
    }

    public OffsetDateTime atTime(OffsetTime offsetTime) {
        return OffsetDateTime.m104of(LocalDateTime.m95of(this, offsetTime.toLocalTime()), offsetTime.getOffset());
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.m95of(this, LocalTime.MIDNIGHT);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        ZoneOffsetTransition transition;
        Objects.requireNonNull(zoneId, "zone");
        LocalDateTime atTime = atTime(LocalTime.MIDNIGHT);
        if (!(zoneId instanceof ZoneOffset) && (transition = zoneId.getRules().getTransition(atTime)) != null && transition.isGap()) {
            atTime = transition.getDateTimeAfter();
        }
        return ZonedDateTime.m117of(atTime, zoneId);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j;
        long j2 = this.year;
        long j3 = this.month;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = j4 + (((3 + j2) / 4) - ((99 + j2) / 100)) + ((j2 + 399) / 400);
        } else {
            j = j4 - (((j2 / (-4)) - (j2 / (-100))) + (j2 / (-400)));
        }
        long j5 = j + (((367 * j3) - 362) / 12) + (this.day - 1);
        if (j3 > 2) {
            j5--;
            if (!isLeapYear()) {
                j5--;
            }
        }
        return j5 - DAYS_0000_TO_1970;
    }

    public long toEpochSecond(LocalTime localTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localTime, "time");
        Objects.requireNonNull(zoneOffset, "offset");
        return ((toEpochDay() * 86400) + localTime.toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, java.lang.Comparable
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate);
        }
        return super.compareTo(chronoLocalDate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int compareTo0(LocalDate localDate) {
        int i = this.year - localDate.year;
        if (i != 0) {
            return i;
        }
        int i2 = this.month - localDate.month;
        return i2 == 0 ? this.day - localDate.day : i2;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate) > 0;
        }
        return super.isAfter(chronoLocalDate);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate) < 0;
        }
        return super.isBefore(chronoLocalDate);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return compareTo0((LocalDate) chronoLocalDate) == 0;
        }
        return super.isEqual(chronoLocalDate);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int hashCode() {
        int i = this.year;
        return (((i << 11) + (this.month << 6)) + this.day) ^ (i & (-2048));
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public String toString() {
        int i = this.year;
        short s = this.month;
        short s2 = this.day;
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000).deleteCharAt(1);
        } else {
            sb.append(i + 10000).deleteCharAt(0);
        }
        return sb.append(s < 10 ? "-0" : "-").append((int) s).append(s2 >= 10 ? "-" : "-0").append((int) s2).toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalDate readExternal(DataInput dataInput) throws IOException {
        return m87of(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }
}
