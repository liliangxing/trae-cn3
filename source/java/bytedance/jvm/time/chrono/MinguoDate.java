package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.Period;
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
public final class MinguoDate extends ChronoLocalDateImpl<MinguoDate> implements ChronoLocalDate, Serializable {
    private static final long serialVersionUID = 1300372329181994526L;
    private final transient LocalDate isoDate;

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    public static MinguoDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static MinguoDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static MinguoDate now(Clock clock) {
        return new MinguoDate(LocalDate.now(clock));
    }

    /* renamed from: of */
    public static MinguoDate m128of(int i, int i2, int i3) {
        return new MinguoDate(LocalDate.m87of(i + 1911, i2, i3));
    }

    public static MinguoDate from(TemporalAccessor temporalAccessor) {
        return MinguoChronology.INSTANCE.date(temporalAccessor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MinguoDate(LocalDate localDate) {
        Objects.requireNonNull(localDate, "isoDate");
        this.isoDate = localDate;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public MinguoChronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public MinguoEra getEra() {
        return getProlepticYear() >= 1 ? MinguoEra.ROC : MinguoEra.BEFORE_ROC;
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (isSupported(temporalField)) {
                ChronoField chronoField = (ChronoField) temporalField;
                int i = C06411.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return this.isoDate.range(temporalField);
                }
                if (i == 4) {
                    ValueRange range = ChronoField.YEAR.range();
                    return ValueRange.m134of(1L, getProlepticYear() <= 0 ? (-range.getMinimum()) + 1 + 1911 : range.getMaximum() - 1911);
                }
                return getChronology().range(chronoField);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.rangeRefinedBy(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.chrono.MinguoDate$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06411 {
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
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = C06411.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
            if (i == 4) {
                int prolepticYear = getProlepticYear();
                if (prolepticYear < 1) {
                    prolepticYear = 1 - prolepticYear;
                }
                return prolepticYear;
            }
            if (i == 5) {
                return getProlepticMonth();
            }
            if (i == 6) {
                return getProlepticYear();
            }
            if (i != 7) {
                return this.isoDate.getLong(temporalField);
            }
            return getProlepticYear() < 1 ? 0 : 1;
        }
        return temporalField.getFrom(this);
    }

    private long getProlepticMonth() {
        return ((getProlepticYear() * 12) + this.isoDate.getMonthValue()) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r1 != 7) goto L20;
     */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MinguoDate with(TemporalField temporalField, long j) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            if (getLong(chronoField) == j) {
                return this;
            }
            int i = C06411.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
            if (i != 4) {
                if (i == 5) {
                    getChronology().range(chronoField).checkValidValue(j, chronoField);
                    return plusMonths(j - getProlepticMonth());
                }
                if (i != 6) {
                }
            }
            int checkValidIntValue = getChronology().range(chronoField).checkValidIntValue(j, chronoField);
            int i2 = C06411.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[chronoField.ordinal()];
            if (i2 == 4) {
                return with(this.isoDate.withYear(getProlepticYear() >= 1 ? checkValidIntValue + 1911 : (1 - checkValidIntValue) + 1911));
            }
            if (i2 == 6) {
                return with(this.isoDate.withYear(checkValidIntValue + 1911));
            }
            if (i2 == 7) {
                return with(this.isoDate.withYear((1 - getProlepticYear()) + 1911));
            }
            return with(this.isoDate.with(temporalField, j));
        }
        return (MinguoDate) super.with(temporalField, j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public MinguoDate with(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) super.with(temporalAdjuster);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public MinguoDate plus(TemporalAmount temporalAmount) {
        return (MinguoDate) super.plus(temporalAmount);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public MinguoDate minus(TemporalAmount temporalAmount) {
        return (MinguoDate) super.minus(temporalAmount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusYears(long j) {
        return with(this.isoDate.plusYears(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusMonths(long j) {
        return with(this.isoDate.plusMonths(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusWeeks(long j) {
        return (MinguoDate) super.plusWeeks(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusDays(long j) {
        return with(this.isoDate.plusDays(j));
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public MinguoDate plus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j, temporalUnit);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl, bytedance.jvm.time.chrono.ChronoLocalDate, bytedance.jvm.time.temporal.Temporal
    public MinguoDate minus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.minus(j, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusYears(long j) {
        return (MinguoDate) super.minusYears(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusMonths(long j) {
        return (MinguoDate) super.minusMonths(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusWeeks(long j) {
        return (MinguoDate) super.minusWeeks(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // bytedance.jvm.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusDays(long j) {
        return (MinguoDate) super.minusDays(j);
    }

    private MinguoDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new MinguoDate(localDate);
    }

    @Override // bytedance.jvm.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<MinguoDate> atTime(LocalTime localTime) {
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
        if (obj instanceof MinguoDate) {
            return this.isoDate.equals(((MinguoDate) obj).isoDate);
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
        return new Ser((byte) 7, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MinguoDate readExternal(DataInput dataInput) throws IOException {
        return MinguoChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }
}
