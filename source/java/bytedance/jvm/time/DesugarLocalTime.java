package bytedance.jvm.time;

import java.util.Objects;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DesugarLocalTime {
    static final long NANOS_PER_SECOND = 1000000000;
    static final int SECONDS_PER_DAY = 86400;

    private DesugarLocalTime() {
    }

    public static long toEpochSecond(LocalTime localTime, LocalDate localDate, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(zoneOffset, "offset");
        return ((localDate.toEpochDay() * 86400) + localTime.toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    public static LocalTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return LocalTime.ofNanoOfDay((UByte$.ExternalSyntheticBackport0.m(instant.getEpochSecond() + zoneId.getRules().getOffset(instant).getTotalSeconds(), SECONDS_PER_DAY) * NANOS_PER_SECOND) + instant.getNano());
    }
}
