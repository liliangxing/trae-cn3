package kotlinx.datetime;

import bytedance.jvm.time.Month;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.DateTimeFormat;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalTime.kt */
@Metadata(m4d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b\u001a-\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\u000b\u001a\u00060\rj\u0002`\f2\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000e\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0000¨\u0006\u0012"}, m5d2 = {"format", BuildConfig.FLAVOR, "Lkotlinx/datetime/LocalTime;", "Lkotlinx/datetime/format/DateTimeFormat;", "toLocalTime", "atDate", "Lkotlinx/datetime/LocalDateTime;", "year", BuildConfig.FLAVOR, "monthNumber", "dayOfMonth", "month", "Lkotlinx/datetime/Month;", "Lbytedance/jvm/time/Month;", "(Lkotlinx/datetime/LocalTime;ILbytedance/jvm/time/Month;I)Lkotlinx/datetime/LocalDateTime;", "date", "Lkotlinx/datetime/LocalDate;", "getIsoTimeFormat", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalTimeKt {
    public static final String format(LocalTime localTime, DateTimeFormat<LocalTime> format) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format(localTime);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "LocalTime.parse(this)", imports = {}))
    public static final LocalTime toLocalTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return LocalTime.Companion.parse$default(LocalTime.INSTANCE, str, null, 2, null);
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return atDate(localTime, i, i2, i3);
    }

    public static final LocalDateTime atDate(LocalTime localTime, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        return new LocalDateTime(i, i2, i3, localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNanosecond());
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, Month month, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return atDate(localTime, i, month, i2);
    }

    public static final LocalDateTime atDate(LocalTime localTime, int i, Month month, int i2) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDateTime(i, month, i2, localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNanosecond());
    }

    public static final LocalDateTime atDate(LocalTime localTime, LocalDate date) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(date, "date");
        return new LocalDateTime(date, localTime);
    }

    public static final DateTimeFormat<LocalTime> getIsoTimeFormat() {
        return LocalTime.Formats.INSTANCE.getISO();
    }
}
