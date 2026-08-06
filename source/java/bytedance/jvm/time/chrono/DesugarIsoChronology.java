package bytedance.jvm.time.chrono;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Month;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.temporal.ChronoField;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DesugarIsoChronology {
    private static final long DAYS_0000_TO_1970 = 719528;

    public static long epochSecond(IsoChronology isoChronology, int i, int i2, int i3, int i4, int i5, int i6, ZoneOffset zoneOffset) {
        long j;
        long j2 = i;
        ChronoField.YEAR.checkValidValue(j2);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
        ChronoField.DAY_OF_MONTH.checkValidValue(i3);
        ChronoField.HOUR_OF_DAY.checkValidValue(i4);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i5);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i6);
        Objects.requireNonNull(zoneOffset, "zoneOffset");
        if (i3 > 28 && i3 > numberOfDaysOfMonth(i, i2)) {
            if (i3 == 29) {
                throw new DateTimeException("Invalid date 'February 29' as '" + i + "' is not a leap year");
            }
            throw new DateTimeException("Invalid date '" + Month.m99of(i2).name() + " " + i3 + "'");
        }
        long j3 = (365 * j2) + 0;
        if (i >= 0) {
            j = j3 + (((3 + j2) / 4) - ((99 + j2) / 100)) + ((399 + j2) / 400);
        } else {
            j = j3 - (((i / (-4)) - (i / (-100))) + (i / (-400)));
        }
        long j4 = j + (((i2 * 367) - 362) / 12) + (i3 - 1);
        if (i2 > 2) {
            j4--;
            if (!IsoChronology.INSTANCE.isLeapYear(j2)) {
                j4--;
            }
        }
        return Math.addExact(Math.multiplyExact(j4 - DAYS_0000_TO_1970, 86400L), ((((i4 * 60) + i5) * 60) + i6) - zoneOffset.getTotalSeconds());
    }

    private static int numberOfDaysOfMonth(int i, int i2) {
        return i2 != 2 ? (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31 : IsoChronology.INSTANCE.isLeapYear((long) i) ? 29 : 28;
    }
}
