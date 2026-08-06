package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.Temporal;
import bytedance.jvm.time.temporal.TemporalAccessor;
import bytedance.jvm.time.temporal.TemporalAdjuster;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.TemporalQueries;
import bytedance.jvm.time.temporal.TemporalQuery;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final DayOfWeek[] ENUMS = values();

    /* renamed from: of */
    public static DayOfWeek m85of(int i) {
        if (i < 1 || i > 7) {
            throw new DateTimeException("Invalid value for DayOfWeek: " + i);
        }
        return ENUMS[i - 1];
    }

    public static DayOfWeek from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return m85of(temporalAccessor.get(ChronoField.DAY_OF_WEEK));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_WEEK, textStyle).toFormatter(locale).format(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.DAY_OF_WEEK : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return temporalField.range();
        }
        return super.range(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        return super.get(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.getFrom(this);
    }

    public DayOfWeek plus(long j) {
        return ENUMS[(ordinal() + (((int) (j % 7)) + 7)) % 7];
    }

    public DayOfWeek minus(long j) {
        return plus(-(j % 7));
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.DAYS;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_WEEK, getValue());
    }
}
