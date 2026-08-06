package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.Period;
import bytedance.jvm.time.Year;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class JapaneseDate extends ChronoLocalDateImpl<JapaneseDate> implements ChronoLocalDate, Serializable {
    static final LocalDate MEIJI_6_ISODATE = LocalDate.m87of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final transient LocalDate isoDate;
    private transient int yearOfEra;

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    public static JapaneseDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static JapaneseDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static JapaneseDate now(Clock clock) {
        return new JapaneseDate(LocalDate.now(clock));
    }

    /* renamed from: of */
    public static JapaneseDate m126of(JapaneseEra japaneseEra, int i, int i2, int i3) {
        Objects.requireNonNull(japaneseEra, "era");
        LocalDate m87of = LocalDate.m87of((japaneseEra.getSince().getYear() + i) - 1, i2, i3);
        if (m87of.isBefore(japaneseEra.getSince()) || japaneseEra != JapaneseEra.from(m87of)) {
            throw new DateTimeException("year, month, and day not valid for Era");
        }
        return new JapaneseDate(japaneseEra, i, m87of);
    }

    /* renamed from: of */
    public static JapaneseDate m125of(int i, int i2, int i3) {
        return new JapaneseDate(LocalDate.m87of(i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseDate ofYearDay(JapaneseEra japaneseEra, int i, int i2) {
        LocalDate ofYearDay;
        Objects.requireNonNull(japaneseEra, "era");
        if (i == 1) {
            ofYearDay = LocalDate.ofYearDay(japaneseEra.getSince().getYear(), (japaneseEra.getSince().getDayOfYear() + i2) - 1);
        } else {
            ofYearDay = LocalDate.ofYearDay((japaneseEra.getSince().getYear() + i) - 1, i2);
        }
        if (ofYearDay.isBefore(japaneseEra.getSince()) || japaneseEra != JapaneseEra.from(ofYearDay)) {
            throw new DateTimeException("Invalid parameters");
        }
        return new JapaneseDate(japaneseEra, i, ofYearDay);
    }

    public static JapaneseDate from(TemporalAccessor temporalAccessor) {
        return JapaneseChronology.INSTANCE.date(temporalAccessor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JapaneseDate(LocalDate localDate) {
        if (localDate.isBefore(MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.era = JapaneseEra.from(localDate);
        this.yearOfEra = (localDate.getYear() - this.era.getSince().getYear()) + 1;
        this.isoDate = localDate;
    }

    JapaneseDate(JapaneseEra japaneseEra, int i, LocalDate localDate) {
        if (localDate.isBefore(MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.era = japaneseEra;
        this.yearOfEra = i;
        this.isoDate = localDate;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public JapaneseEra getEra() {
        return this.era;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfYear() {
        int lengthOfYear;
        JapaneseEra next = this.era.next();
        if (next != null && next.getSince().getYear() == this.isoDate.getYear()) {
            lengthOfYear = next.getSince().getDayOfYear() - 1;
        } else {
            lengthOfYear = this.isoDate.lengthOfYear();
        }
        return this.yearOfEra == 1 ? lengthOfYear - (this.era.getSince().getDayOfYear() - 1) : lengthOfYear;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || temporalField == ChronoField.ALIGNED_WEEK_OF_MONTH || temporalField == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (temporalField instanceof ChronoField) {
            return temporalField.isDateBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (isSupported(temporalField)) {
                ChronoField chronoField = (ChronoField) temporalField;
                int i = C06391.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
                if (i == 1) {
                    return ValueRange.m134of(1L, lengthOfMonth());
                }
                if (i == 2) {
                    return ValueRange.m134of(1L, lengthOfYear());
                }
                if (i == 3) {
                    int year = this.era.getSince().getYear();
                    if (this.era.next() != null) {
                        return ValueRange.m134of(1L, (r0.getSince().getYear() - year) + 1);
                    }
                    return ValueRange.m134of(1L, Year.MAX_VALUE - year);
                }
                return getChronology().range(chronoField);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            switch ((ChronoField) temporalField) {
                case DAY_OF_YEAR:
                    if (this.yearOfEra == 1) {
                        return (this.isoDate.getDayOfYear() - this.era.getSince().getDayOfYear()) + 1;
                    }
                    return this.isoDate.getDayOfYear();
                case YEAR_OF_ERA:
                    return this.yearOfEra;
                case ALIGNED_DAY_OF_WEEK_IN_MONTH:
                case ALIGNED_DAY_OF_WEEK_IN_YEAR:
                case ALIGNED_WEEK_OF_MONTH:
                case ALIGNED_WEEK_OF_YEAR:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
                case ERA:
                    return this.era.getValue();
                default:
                    return this.isoDate.getLong(temporalField);
            }
        }
        return temporalField.getFrom(this);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public JapaneseDate with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            if (getLong(chronoField) == j) {
                return this;
            }
            int i = C06391.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
            if (i == 3 || i == 8 || i == 9) {
                int checkValidIntValue = getChronology().range(chronoField).checkValidIntValue(j, chronoField);
                int i2 = C06391.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
                if (i2 == 3) {
                    return withYear(checkValidIntValue);
                }
                if (i2 == 8) {
                    return withYear(JapaneseEra.m127of(checkValidIntValue), this.yearOfEra);
                }
                if (i2 == 9) {
                    return with(this.isoDate.withYear(checkValidIntValue));
                }
            }
            return with(this.isoDate.with(temporalField, j));
        }
        return (JapaneseDate) super.with(temporalField, j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public JapaneseDate with(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) super.with(temporalAdjuster);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public JapaneseDate plus(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.plus(temporalAmount);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public JapaneseDate minus(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.minus(temporalAmount);
    }

    private JapaneseDate withYear(JapaneseEra japaneseEra, int i) {
        return with(this.isoDate.withYear(JapaneseChronology.INSTANCE.prolepticYear(japaneseEra, i)));
    }

    private JapaneseDate withYear(int i) {
        return withYear(getEra(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate plusYears(long j) {
        return with(this.isoDate.plusYears(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate plusMonths(long j) {
        return with(this.isoDate.plusMonths(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate plusWeeks(long j) {
        return with(this.isoDate.plusWeeks(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate plusDays(long j) {
        return with(this.isoDate.plusDays(j));
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public JapaneseDate plus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j, temporalUnit);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public JapaneseDate minus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.minus(j, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate minusYears(long j) {
        return (JapaneseDate) super.minusYears(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate minusMonths(long j) {
        return (JapaneseDate) super.minusMonths(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate minusWeeks(long j) {
        return (JapaneseDate) super.minusWeeks(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public JapaneseDate minusDays(long j) {
        return (JapaneseDate) super.minusDays(j);
    }

    private JapaneseDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<JapaneseDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        Period until = this.isoDate.until(chronoLocalDate);
        return getChronology().period(until.getYears(), until.getMonths(), until.getDays());
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.isoDate.equals(((JapaneseDate) obj).isoDate);
        }
        return false;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JapaneseDate readExternal(DataInput dataInput) throws IOException {
        return JapaneseChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }
}
