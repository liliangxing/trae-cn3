package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.format.DateTimeFormat;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateTime.kt */
@Metadata(m4d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0000¨\u0006\u0006"}, m5d2 = {"format", BuildConfig.FLAVOR, "Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/format/DateTimeFormat;", "toLocalDateTime", "getIsoDateTimeFormat", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDateTimeKt {
    public static final String format(LocalDateTime localDateTime, DateTimeFormat<LocalDateTime> format) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format(localDateTime);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "LocalDateTime.parse(this)", imports = {}))
    public static final LocalDateTime toLocalDateTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return LocalDateTime.Companion.parse$default(LocalDateTime.INSTANCE, str, null, 2, null);
    }

    public static final DateTimeFormat<LocalDateTime> getIsoDateTimeFormat() {
        return LocalDateTime.Formats.INSTANCE.getISO();
    }
}
