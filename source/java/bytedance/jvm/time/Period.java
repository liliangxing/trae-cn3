package bytedance.jvm.time;

import androidx.core.location.LocationRequestCompat;
import bytedance.jvm.time.chrono.ChronoLocalDate;
import bytedance.jvm.time.chrono.ChronoPeriod;
import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.format.DateTimeParseException;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAmount;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Period implements ChronoPeriod, Serializable {
    private static final long serialVersionUID = -3587258372562876L;
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    private static final List<TemporalUnit> SUPPORTED_UNITS = UByte$.ExternalSyntheticBackport0.m(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS);

    public static Period ofYears(int i) {
        return create(i, 0, 0);
    }

    public static Period ofMonths(int i) {
        return create(0, i, 0);
    }

    public static Period ofWeeks(int i) {
        return create(0, 0, Math.multiplyExact(i, 7));
    }

    public static Period ofDays(int i) {
        return create(0, 0, i);
    }

    /* renamed from: of */
    public static Period m107of(int i, int i2, int i3) {
        return create(i, i2, i3);
    }

    public static Period from(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return (Period) temporalAmount;
        }
        if ((temporalAmount instanceof ChronoPeriod) && !IsoChronology.INSTANCE.equals(((ChronoPeriod) temporalAmount).getChronology())) {
            throw new DateTimeException("Period requires ISO chronology: " + temporalAmount);
        }
        Objects.requireNonNull(temporalAmount, "amount");
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (TemporalUnit temporalUnit : temporalAmount.getUnits()) {
            long j = temporalAmount.get(temporalUnit);
            if (temporalUnit == ChronoUnit.YEARS) {
                i = Math.toIntExact(j);
            } else if (temporalUnit == ChronoUnit.MONTHS) {
                i2 = Math.toIntExact(j);
            } else if (temporalUnit == ChronoUnit.DAYS) {
                i3 = Math.toIntExact(j);
            } else {
                throw new DateTimeException("Unit must be Years, Months or Days, but was " + temporalUnit);
            }
        }
        return create(i, i2, i3);
    }

    public static Period parse(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, StrategyConstants.TEXT);
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            int i = charMatch(charSequence, matcher.start(1), matcher.end(1), '-') ? -1 : 1;
            int start = matcher.start(2);
            int end = matcher.end(2);
            int start2 = matcher.start(3);
            int end2 = matcher.end(3);
            int start3 = matcher.start(4);
            int end3 = matcher.end(4);
            int start4 = matcher.start(5);
            int end4 = matcher.end(5);
            if (start >= 0 || start2 >= 0 || start3 >= 0 || start4 >= 0) {
                try {
                    return create(parseNumber(charSequence, start, end, i), parseNumber(charSequence, start2, end2, i), Math.addExact(parseNumber(charSequence, start4, end4, i), Math.multiplyExact(parseNumber(charSequence, start3, end3, i), 7)));
                } catch (NumberFormatException e) {
                    throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0, e);
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static boolean charMatch(CharSequence charSequence, int i, int i2, char c) {
        return i >= 0 && i2 == i + 1 && charSequence.charAt(i) == c;
    }

    private static int parseNumber(CharSequence charSequence, int i, int i2, int i3) {
        if (i < 0 || i2 < 0) {
            return 0;
        }
        if (charSequence.charAt(i) == '+') {
            i++;
        }
        try {
            return Math.multiplyExact(UByte$.ExternalSyntheticBackport0.m(charSequence, i, i2, 10), i3);
        } catch (ArithmeticException e) {
            throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0, e);
        }
    }

    public static Period between(LocalDate localDate, LocalDate localDate2) {
        return localDate.until((ChronoLocalDate) localDate2);
    }

    private static Period create(int i, int i2, int i3) {
        if ((i | i2 | i3) == 0) {
            return ZERO;
        }
        return new Period(i, i2, i3);
    }

    private Period(int i, int i2, int i3) {
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod, bytedance.jvm.time.temporal.TemporalAmount
    public long get(TemporalUnit temporalUnit) {
        int days;
        if (temporalUnit == ChronoUnit.YEARS) {
            days = getYears();
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            days = getMonths();
        } else if (temporalUnit == ChronoUnit.DAYS) {
            days = getDays();
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return days;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod, bytedance.jvm.time.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public boolean isZero() {
        return this == ZERO;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    public int getYears() {
        return this.years;
    }

    public int getMonths() {
        return this.months;
    }

    public int getDays() {
        return this.days;
    }

    public Period withYears(int i) {
        return i == this.years ? this : create(i, this.months, this.days);
    }

    public Period withMonths(int i) {
        return i == this.months ? this : create(this.years, i, this.days);
    }

    public Period withDays(int i) {
        return i == this.days ? this : create(this.years, this.months, i);
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public Period plus(TemporalAmount temporalAmount) {
        Period from = from(temporalAmount);
        return create(Math.addExact(this.years, from.years), Math.addExact(this.months, from.months), Math.addExact(this.days, from.days));
    }

    public Period plusYears(long j) {
        return j == 0 ? this : create(Math.toIntExact(Math.addExact(this.years, j)), this.months, this.days);
    }

    public Period plusMonths(long j) {
        return j == 0 ? this : create(this.years, Math.toIntExact(Math.addExact(this.months, j)), this.days);
    }

    public Period plusDays(long j) {
        return j == 0 ? this : create(this.years, this.months, Math.toIntExact(Math.addExact(this.days, j)));
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public Period minus(TemporalAmount temporalAmount) {
        Period from = from(temporalAmount);
        return create(Math.subtractExact(this.years, from.years), Math.subtractExact(this.months, from.months), Math.subtractExact(this.days, from.days));
    }

    public Period minusYears(long j) {
        return j == Long.MIN_VALUE ? plusYears(LocationRequestCompat.PASSIVE_INTERVAL).plusYears(1L) : plusYears(-j);
    }

    public Period minusMonths(long j) {
        return j == Long.MIN_VALUE ? plusMonths(LocationRequestCompat.PASSIVE_INTERVAL).plusMonths(1L) : plusMonths(-j);
    }

    public Period minusDays(long j) {
        return j == Long.MIN_VALUE ? plusDays(LocationRequestCompat.PASSIVE_INTERVAL).plusDays(1L) : plusDays(-j);
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public Period multipliedBy(int i) {
        return (this == ZERO || i == 1) ? this : create(Math.multiplyExact(this.years, i), Math.multiplyExact(this.months, i), Math.multiplyExact(this.days, i));
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public Period negated() {
        return multipliedBy(-1);
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public Period normalized() {
        long totalMonths = toTotalMonths();
        long j = totalMonths / 12;
        int i = (int) (totalMonths % 12);
        return (j == ((long) this.years) && i == this.months) ? this : create(Math.toIntExact(j), i, this.days);
    }

    public long toTotalMonths() {
        return (this.years * 12) + this.months;
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
            long totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                temporal = temporal.plus(totalMonths, ChronoUnit.MONTHS);
            }
        }
        int i2 = this.days;
        return i2 != 0 ? temporal.plus(i2, ChronoUnit.DAYS) : temporal;
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
            long totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                temporal = temporal.minus(totalMonths, ChronoUnit.MONTHS);
            }
        }
        int i2 = this.days;
        return i2 != 0 ? temporal.minus(i2, ChronoUnit.DAYS) : temporal;
    }

    private void validateChrono(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null && !IsoChronology.INSTANCE.equals(chronology)) {
            throw new DateTimeException("Chronology mismatch, expected: ISO, actual: " + chronology.getId());
        }
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    @Override // bytedance.jvm.time.chrono.ChronoPeriod
    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
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

    private Object writeReplace() {
        return new Ser((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.years);
        dataOutput.writeInt(this.months);
        dataOutput.writeInt(this.days);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Period readExternal(DataInput dataInput) throws IOException {
        return m107of(dataInput.readInt(), dataInput.readInt(), dataInput.readInt());
    }
}
