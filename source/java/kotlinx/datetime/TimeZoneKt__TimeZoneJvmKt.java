package kotlinx.datetime;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.BuildConfig;

/* compiled from: TimeZoneJvm.kt */
@Metadata(m4d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\t2\u0006\u0010\f\u001a\u00020\u0007\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u000e\u001a\u00020\t*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000e\u001a\u00020\t*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006\u001a\u0012\u0010\u000f\u001a\u00020\t*\u00020\u00102\u0006\u0010\f\u001a\u00020\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, m5d2 = {"isFixedOffset", BuildConfig.FLAVOR, "Lbytedance/jvm/time/ZoneId;", "isFixedOffset$TimeZoneKt__TimeZoneJvmKt", "(Lbytedance/jvm/time/ZoneId;)Z", "offsetAt", "Lkotlinx/datetime/UtcOffset;", "Lkotlinx/datetime/TimeZone;", "instant", "Lkotlinx/datetime/Instant;", "toLocalDateTime", "Lkotlinx/datetime/LocalDateTime;", "timeZone", "offset", "toInstant", "atStartOfDayIn", "Lkotlinx/datetime/LocalDate;", "kotlinx-datetime_release"}, m6k = 5, m7mv = {2, 0, 0}, m9xi = 48, m10xs = "kotlinx/datetime/TimeZoneKt")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final /* synthetic */ class TimeZoneKt__TimeZoneJvmKt {
    public static final boolean isFixedOffset$TimeZoneKt__TimeZoneJvmKt(ZoneId zoneId) {
        try {
            return zoneId.getRules().isFixedOffset();
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    public static final UtcOffset offsetAt(TimeZone timeZone, Instant instant) {
        Intrinsics.checkNotNullParameter(timeZone, "<this>");
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new UtcOffset(timeZone.getZoneId().getRules().getOffset(instant.getValue()));
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            return new LocalDateTime(bytedance.jvm.time.LocalDateTime.ofInstant(instant.getValue(), timeZone.getZoneId()));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, UtcOffset offset) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        try {
            return new LocalDateTime(bytedance.jvm.time.LocalDateTime.ofInstant(instant.getValue(), offset.getZoneOffset()));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant toInstant(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(localDateTime.getValue().atZone(timeZone.getZoneId()).toInstant());
    }

    public static final Instant toInstant(LocalDateTime localDateTime, UtcOffset offset) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        return new Instant(localDateTime.getValue().toInstant(offset.getZoneOffset()));
    }

    public static final Instant atStartOfDayIn(LocalDate localDate, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(localDate.getValue().atStartOfDay(timeZone.getZoneId()).toInstant());
    }
}
