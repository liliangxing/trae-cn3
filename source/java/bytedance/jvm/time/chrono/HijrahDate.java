package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
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
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class HijrahDate extends ChronoLocalDateImpl<HijrahDate> implements ChronoLocalDate, Serializable {
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient HijrahChronology chrono;
    private final transient int dayOfMonth;
    private final transient int monthOfYear;
    private final transient int prolepticYear;

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: of */
    public static HijrahDate m122of(HijrahChronology hijrahChronology, int i, int i2, int i3) {
        return new HijrahDate(hijrahChronology, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HijrahDate ofEpochDay(HijrahChronology hijrahChronology, long j) {
        return new HijrahDate(hijrahChronology, j);
    }

    public static HijrahDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static HijrahDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static HijrahDate now(Clock clock) {
        return ofEpochDay(HijrahChronology.INSTANCE, LocalDate.now(clock).toEpochDay());
    }

    /* renamed from: of */
    public static HijrahDate m121of(int i, int i2, int i3) {
        return HijrahChronology.INSTANCE.date(i, i2, i3);
    }

    public static HijrahDate from(TemporalAccessor temporalAccessor) {
        return HijrahChronology.INSTANCE.date(temporalAccessor);
    }

    private HijrahDate(HijrahChronology hijrahChronology, int i, int i2, int i3) {
        hijrahChronology.getEpochDay(i, i2, i3);
        this.chrono = hijrahChronology;
        this.prolepticYear = i;
        this.monthOfYear = i2;
        this.dayOfMonth = i3;
    }

    private HijrahDate(HijrahChronology hijrahChronology, long j) {
        int[] hijrahDateInfo = hijrahChronology.getHijrahDateInfo((int) j);
        this.chrono = hijrahChronology;
        this.prolepticYear = hijrahDateInfo[0];
        this.monthOfYear = hijrahDateInfo[1];
        this.dayOfMonth = hijrahDateInfo[2];
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public HijrahChronology getChronology() {
        return this.chrono;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public HijrahEra getEra() {
        return HijrahEra.AH;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.chrono.getMonthLength(this.prolepticYear, this.monthOfYear);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return this.chrono.getYearLength(this.prolepticYear);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (isSupported(temporalField)) {
                ChronoField chronoField = (ChronoField) temporalField;
                int i = C06371.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
                if (i == 1) {
                    return ValueRange.m134of(1L, lengthOfMonth());
                }
                if (i == 2) {
                    return ValueRange.m134of(1L, lengthOfYear());
                }
                if (i == 3) {
                    return ValueRange.m134of(1L, 5L);
                }
                return getChronology().range(chronoField);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.HijrahDate$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06371 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000f. Please report as an issue. */
    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i;
        int i2;
        if (temporalField instanceof ChronoField) {
            switch (C06371.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
                case 1:
                    i = this.dayOfMonth;
                    return i;
                case 2:
                    i = getDayOfYear();
                    return i;
                case 3:
                    i2 = (this.dayOfMonth - 1) / 7;
                    i = i2 + 1;
                    return i;
                case 4:
                    i = getDayOfWeek();
                    return i;
                case 5:
                    i2 = (this.dayOfMonth - 1) % 7;
                    i = i2 + 1;
                    return i;
                case 6:
                    i2 = (getDayOfYear() - 1) % 7;
                    i = i2 + 1;
                    return i;
                case 7:
                    return toEpochDay();
                case 8:
                    i2 = (getDayOfYear() - 1) / 7;
                    i = i2 + 1;
                    return i;
                case 9:
                    i = this.monthOfYear;
                    return i;
                case 10:
                    return getProlepticMonth();
                case 11:
                    i = this.prolepticYear;
                    return i;
                case 12:
                    i = this.prolepticYear;
                    return i;
                case 13:
                    i = getEraValue();
                    return i;
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return temporalField.getFrom(this);
    }

    private long getProlepticMonth() {
        return ((this.prolepticYear * 12) + this.monthOfYear) - 1;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public HijrahDate with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            this.chrono.range(chronoField).checkValidValue(j, chronoField);
            int i = (int) j;
            switch (C06371.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return resolvePreviousValid(this.prolepticYear, this.monthOfYear, i);
                case 2:
                    return plusDays(Math.min(i, lengthOfYear()) - getDayOfYear());
                case 3:
                    return plusDays((j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
                case 4:
                    return plusDays(j - getDayOfWeek());
                case 5:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 6:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 7:
                    return new HijrahDate(this.chrono, j);
                case 8:
                    return plusDays((j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
                case 9:
                    return resolvePreviousValid(this.prolepticYear, i, this.dayOfMonth);
                case 10:
                    return plusMonths(j - getProlepticMonth());
                case 11:
                    if (this.prolepticYear < 1) {
                        i = 1 - i;
                    }
                    return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
                case 12:
                    return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
                case 13:
                    return resolvePreviousValid(1 - this.prolepticYear, this.monthOfYear, this.dayOfMonth);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (HijrahDate) super.with(temporalField, j);
    }

    private HijrahDate resolvePreviousValid(int i, int i2, int i3) {
        int monthLength = this.chrono.getMonthLength(i, i2);
        if (i3 > monthLength) {
            i3 = monthLength;
        }
        return m122of(this.chrono, i, i2, i3);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public HijrahDate with(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) super.with(temporalAdjuster);
    }

    public HijrahDate withVariant(HijrahChronology hijrahChronology) {
        if (this.chrono == hijrahChronology) {
            return this;
        }
        int dayOfYear = hijrahChronology.getDayOfYear(this.prolepticYear, this.monthOfYear);
        int i = this.prolepticYear;
        int i2 = this.monthOfYear;
        int i3 = this.dayOfMonth;
        if (i3 <= dayOfYear) {
            dayOfYear = i3;
        }
        return m122of(hijrahChronology, i, i2, dayOfYear);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public HijrahDate plus(TemporalAmount temporalAmount) {
        return (HijrahDate) super.plus(temporalAmount);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public HijrahDate minus(TemporalAmount temporalAmount) {
        return (HijrahDate) super.minus(temporalAmount);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.chrono.getEpochDay(this.prolepticYear, this.monthOfYear, this.dayOfMonth);
    }

    private int getDayOfYear() {
        return this.chrono.getDayOfYear(this.prolepticYear, this.monthOfYear) + this.dayOfMonth;
    }

    private int getDayOfWeek() {
        return UByte$.ExternalSyntheticBackport0.m(toEpochDay() + 3, 7) + 1;
    }

    private int getEraValue() {
        return this.prolepticYear > 1 ? 1 : 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return this.chrono.isLeapYear(this.prolepticYear);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate plusYears(long j) {
        return j == 0 ? this : resolvePreviousValid(Math.addExact(this.prolepticYear, (int) j), this.monthOfYear, this.dayOfMonth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.prolepticYear * 12) + (this.monthOfYear - 1) + j;
        return resolvePreviousValid(this.chrono.checkValidYear(Math.floorDiv(j2, 12L)), ((int) Math.floorMod(j2, 12L)) + 1, this.dayOfMonth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate plusWeeks(long j) {
        return (HijrahDate) super.plusWeeks(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate plusDays(long j) {
        return new HijrahDate(this.chrono, toEpochDay() + j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public HijrahDate plus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j, temporalUnit);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public HijrahDate minus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.minus(j, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate minusYears(long j) {
        return (HijrahDate) super.minusYears(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate minusMonths(long j) {
        return (HijrahDate) super.minusMonths(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate minusWeeks(long j) {
        return (HijrahDate) super.minusWeeks(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public HijrahDate minusDays(long j) {
        return (HijrahDate) super.minusDays(j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<HijrahDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        HijrahDate date = getChronology().date((TemporalAccessor) chronoLocalDate);
        long j = ((date.prolepticYear - this.prolepticYear) * 12) + (date.monthOfYear - this.monthOfYear);
        int i = date.dayOfMonth - this.dayOfMonth;
        if (j > 0 && i < 0) {
            j--;
            i = (int) (date.toEpochDay() - plusMonths(j).toEpochDay());
        } else if (j < 0 && i > 0) {
            j++;
            i -= date.lengthOfMonth();
        }
        return getChronology().period(Math.toIntExact(j / 12), (int) (j % 12), i);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HijrahDate)) {
            return false;
        }
        HijrahDate hijrahDate = (HijrahDate) obj;
        return this.prolepticYear == hijrahDate.prolepticYear && this.monthOfYear == hijrahDate.monthOfYear && this.dayOfMonth == hijrahDate.dayOfMonth && getChronology().equals(hijrahDate.getChronology());
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public int hashCode() {
        int i = this.prolepticYear;
        int i2 = this.monthOfYear;
        int i3 = this.dayOfMonth;
        return (((i << 11) + (i2 << 6)) + i3) ^ (getChronology().getId().hashCode() ^ (i & (-2048)));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(getChronology());
        objectOutput.writeInt(get(ChronoField.YEAR));
        objectOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        objectOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HijrahDate readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((HijrahChronology) objectInput.readObject()).date(objectInput.readInt(), (int) objectInput.readByte(), (int) objectInput.readByte());
    }
}
