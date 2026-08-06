package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.ChronoField;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public enum MinguoEra implements Era {
    BEFORE_ROC,
    ROC;

    /* renamed from: of */
    public static MinguoEra m129of(int i) {
        if (i == 0) {
            return BEFORE_ROC;
        }
        if (i == 1) {
            return ROC;
        }
        throw new DateTimeException("Invalid era: " + i);
    }

    @Override // bytedance.jvm.time.chrono.Era
    public int getValue() {
        return ordinal();
    }

    @Override // bytedance.jvm.time.chrono.Era
    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.ERA, textStyle).toFormatter(locale).withChronology(MinguoChronology.INSTANCE).format(this == ROC ? MinguoDate.m128of(1, 1, 1) : MinguoDate.m128of(0, 1, 1));
    }
}
