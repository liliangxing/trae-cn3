package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.UByte$;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ChronoPeriodImpl implements ChronoPeriod, Serializable {
    private static final List<TemporalUnit> SUPPORTED_UNITS = UByte$.ExternalSyntheticBackport0.m$1(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS);
    private static final long serialVersionUID = 57387258289L;
    private final Chronology chrono;
    final int days;
    final int months;
    final int years;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronoPeriodImpl(Chronology chronology, int i, int i2, int i3) {
        Objects.requireNonNull(chronology, "chrono");
        this.chrono = chronology;
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod, bytedance.jvm.time.temporal.TemporalAmount
    public long get(TemporalUnit temporalUnit) {
        int i;
        if (temporalUnit == ChronoUnit.YEARS) {
            i = this.years;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i = this.months;
        } else if (temporalUnit == ChronoUnit.DAYS) {
            i = this.days;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return i;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod, bytedance.jvm.time.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public Chronology getChronology() {
        return this.chrono;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public boolean isZero() {
        return this.years == 0 && this.months == 0 && this.days == 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public ChronoPeriod plus(TemporalAmount temporalAmount) {
        ChronoPeriodImpl validateAmount = validateAmount(temporalAmount);
        return new ChronoPeriodImpl(this.chrono, Math.addExact(this.years, validateAmount.years), Math.addExact(this.months, validateAmount.months), Math.addExact(this.days, validateAmount.days));
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public ChronoPeriod minus(TemporalAmount temporalAmount) {
        ChronoPeriodImpl validateAmount = validateAmount(temporalAmount);
        return new ChronoPeriodImpl(this.chrono, Math.subtractExact(this.years, validateAmount.years), Math.subtractExact(this.months, validateAmount.months), Math.subtractExact(this.days, validateAmount.days));
    }

    private ChronoPeriodImpl validateAmount(TemporalAmount temporalAmount) {
        Objects.requireNonNull(temporalAmount, "amount");
        if (!(temporalAmount instanceof ChronoPeriodImpl)) {
            throw new DateTimeException("Unable to obtain ChronoPeriod from TemporalAmount: " + temporalAmount.getClass());
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
        if (this.chrono.equals(chronoPeriodImpl.getChronology())) {
            return chronoPeriodImpl;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + this.chrono.getId() + ", actual: " + chronoPeriodImpl.getChronology().getId());
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public ChronoPeriod multipliedBy(int i) {
        return (isZero() || i == 1) ? this : new ChronoPeriodImpl(this.chrono, Math.multiplyExact(this.years, i), Math.multiplyExact(this.months, i), Math.multiplyExact(this.days, i));
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public ChronoPeriod normalized() {
        long monthRange = monthRange();
        if (monthRange <= 0) {
            return this;
        }
        int i = this.years;
        int i2 = this.months;
        long j = (i * monthRange) + i2;
        long j2 = j / monthRange;
        int i3 = (int) (j % monthRange);
        return (j2 == ((long) i) && i3 == i2) ? this : new ChronoPeriodImpl(this.chrono, Math.toIntExact(j2), i3, this.days);
    }

    private long monthRange() {
        ValueRange range = this.chrono.range(ChronoField.MONTH_OF_YEAR);
        if (range.isFixed() && range.isIntValue()) {
            return (range.getMaximum() - range.getMinimum()) + 1;
        }
        return -1L;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod, bytedance.jvm.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        validateChrono(temporal);
        if (this.months == 0) {
            int i = this.years;
            if (i != 0) {
                temporal = temporal.plus(i, ChronoUnit.YEARS);
            }
        } else {
            long monthRange = monthRange();
            if (monthRange > 0) {
                temporal = temporal.plus((this.years * monthRange) + this.months, ChronoUnit.MONTHS);
            } else {
                int i2 = this.years;
                if (i2 != 0) {
                    temporal = temporal.plus(i2, ChronoUnit.YEARS);
                }
                temporal = temporal.plus(this.months, ChronoUnit.MONTHS);
            }
        }
        int i3 = this.days;
        return i3 != 0 ? temporal.plus(i3, ChronoUnit.DAYS) : temporal;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod, bytedance.jvm.time.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        validateChrono(temporal);
        if (this.months == 0) {
            int i = this.years;
            if (i != 0) {
                temporal = temporal.minus(i, ChronoUnit.YEARS);
            }
        } else {
            long monthRange = monthRange();
            if (monthRange > 0) {
                temporal = temporal.minus((this.years * monthRange) + this.months, ChronoUnit.MONTHS);
            } else {
                int i2 = this.years;
                if (i2 != 0) {
                    temporal = temporal.minus(i2, ChronoUnit.YEARS);
                }
                temporal = temporal.minus(this.months, ChronoUnit.MONTHS);
            }
        }
        int i3 = this.days;
        return i3 != 0 ? temporal.minus(i3, ChronoUnit.DAYS) : temporal;
    }

    private void validateChrono(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null && !this.chrono.equals(chronology)) {
            throw new DateTimeException("Chronology mismatch, expected: " + this.chrono.getId() + ", actual: " + chronology.getId());
        }
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoPeriodImpl)) {
            return false;
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
        return this.years == chronoPeriodImpl.years && this.months == chronoPeriodImpl.months && this.days == chronoPeriodImpl.days && this.chrono.equals(chronoPeriodImpl.chrono);
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public int hashCode() {
        return ((this.years + Integer.rotateLeft(this.months, 8)) + Integer.rotateLeft(this.days, 16)) ^ this.chrono.hashCode();
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public String toString() {
        if (isZero()) {
            return getChronology().toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getChronology().toString()).append(" P");
        int i = this.years;
        if (i != 0) {
            sb.append(i).append('Y');
        }
        int i2 = this.months;
        if (i2 != 0) {
            sb.append(i2).append('M');
        }
        int i3 = this.days;
        if (i3 != 0) {
            sb.append(i3).append('D');
        }
        return sb.toString();
    }

    protected Object writeReplace() {
        return new Ser((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.chrono.getId());
        dataOutput.writeInt(this.years);
        dataOutput.writeInt(this.months);
        dataOutput.writeInt(this.days);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChronoPeriodImpl readExternal(DataInput dataInput) throws IOException {
        return new ChronoPeriodImpl(Chronology.m120of(dataInput.readUTF()), dataInput.readInt(), dataInput.readInt(), dataInput.readInt());
    }
}
