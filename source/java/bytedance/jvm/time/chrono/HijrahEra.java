package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.TemporalField;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public enum HijrahEra implements Era {
    AH;

    @Override // bytedance.jvm.time.chrono.Era
    public int getValue() {
        return 1;
    }

    /* renamed from: of */
    public static HijrahEra m123of(int i) {
        if (i == 1) {
            return AH;
        }
        throw new DateTimeException("Invalid era: " + i);
    }

    @Override // bytedance.jvm.time.chrono.Era, bytedance.jvm.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return ValueRange.m134of(1L, 1L);
        }
        return super.range(temporalField);
    }

    @Override // bytedance.jvm.time.chrono.Era
    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, textStyle).toFormatter(locale).withChronology(HijrahChronology.INSTANCE).format(HijrahDate.now());
    }
}
