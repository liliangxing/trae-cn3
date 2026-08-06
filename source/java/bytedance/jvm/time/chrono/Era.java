package bytedance.jvm.time.chrono;

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
public interface Era extends TemporalAccessor, TemporalAdjuster {
    int getValue();

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default int get(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return getValue();
        }
        return super.get(temporalField);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return getValue();
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return temporalField.getFrom(this);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAccessor
    default <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.ERAS;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // bytedance.jvm.time.temporal.TemporalAdjuster
    default Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.ERA, getValue());
    }

    default String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, textStyle).toFormatter(locale).format(this);
    }
}
