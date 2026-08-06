package bytedance.jvm.time;

import bytedance.jvm.time.chrono.Chronology;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.format.DateTimeFormatter;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
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
public final class MonthDay implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static MonthDay now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return m101of(now.getMonth(), now.getDayOfMonth());
    }

    /* renamed from: of */
    public static MonthDay m101of(Month month, int i) {
        Objects.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i);
        if (i > month.maxLength()) {
            throw new DateTimeException("Illegal value for DayOfMonth field, value " + i + " is not valid for month " + month.name());
        }
        return new MonthDay(month.getValue(), i);
    }

    /* renamed from: of */
    public static MonthDay m100of(int i, int i2) {
        return m101of(Month.m99of(i), i2);
    }

    public static MonthDay from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MonthDay) {
            return (MonthDay) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return m100of(temporalAccessor.get(ChronoField.MONTH_OF_YEAR), temporalAccessor.get(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static MonthDay parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    public static MonthDay parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (MonthDay) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: bytedance.jvm.time.MonthDay$$ExternalSyntheticLambda0
            @Override // bytedance.jvm.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return MonthDay.from(temporalAccessor);
            }
        });
    }

    private MonthDay(int i, int i2) {
        this.month = i;
        this.day = i2;
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.range();
        }
        if (temporalField == ChronoField.DAY_OF_MONTH) {
            return ValueRange.m135of(1L, getMonth().minLength(), getMonth().maxLength());
        }
        return super.range(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bytedance.jvm.time.MonthDay$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C06241 {
        static final /* synthetic */ int[] $SwitchMap$bytedance$jvm$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$bytedance$jvm$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$bytedance$jvm$time$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i;
        if (temporalField instanceof ChronoField) {
            int i2 = C06241.$SwitchMap$bytedance$jvm$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
            if (i2 == 1) {
                i = this.day;
            } else if (i2 == 2) {
                i = this.month;
            } else {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            return i;
        }
        return temporalField.getFrom(this);
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

    public boolean isValidYear(int i) {
        return !(this.day == 29 && this.month == 2 && !Year.isLeap((long) i));
    }

    public MonthDay withMonth(int i) {
        return with(Month.m99of(i));
    }

    public MonthDay with(Month month) {
        Objects.requireNonNull(month, "month");
        if (month.getValue() == this.month) {
            return this;
        }
        return new MonthDay(month.getValue(), Math.min(this.day, month.maxLength()));
    }

    public MonthDay withDayOfMonth(int i) {
        return i == this.day ? this : m100of(this.month, i);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) IsoChronology.INSTANCE;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        if (!Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        Temporal with = temporal.with(ChronoField.MONTH_OF_YEAR, this.month);
        return with.with(ChronoField.DAY_OF_MONTH, Math.min(with.range(ChronoField.DAY_OF_MONTH).getMaximum(), this.day));
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public LocalDate atYear(int i) {
        return LocalDate.m87of(i, this.month, isValidYear(i) ? this.day : 28);
    }

    @Override // java.lang.Comparable
    public int compareTo(MonthDay monthDay) {
        int i = this.month - monthDay.month;
        return i == 0 ? this.day - monthDay.day : i;
    }

    public boolean isAfter(MonthDay monthDay) {
        return compareTo(monthDay) > 0;
    }

    public boolean isBefore(MonthDay monthDay) {
        return compareTo(monthDay) < 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        return this.month == monthDay.month && this.day == monthDay.day;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public String toString() {
        return new StringBuilder(10).append("--").append(this.month < 10 ? "0" : "").append(this.month).append(this.day < 10 ? "-0" : "-").append(this.day).toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MonthDay readExternal(DataInput dataInput) throws IOException {
        return m100of(dataInput.readByte(), dataInput.readByte());
    }
}
