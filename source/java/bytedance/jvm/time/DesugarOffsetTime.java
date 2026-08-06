package bytedance.jvm.time;

import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DesugarOffsetTime {
    private DesugarOffsetTime() {
    }

    public static long toEpochSecond(OffsetTime offsetTime, LocalDate localDate) {
        Objects.requireNonNull(localDate, "date");
        return ((localDate.toEpochDay() * 86400) + offsetTime.toLocalTime().toSecondOfDay()) - offsetTime.getOffset().getTotalSeconds();
    }
}
