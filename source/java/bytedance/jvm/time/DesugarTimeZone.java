package bytedance.jvm.time;

import java.util.TimeZone;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DesugarTimeZone {
    private DesugarTimeZone() {
    }

    public static TimeZone getTimeZone(String str) {
        return TimeZone.getTimeZone(str);
    }

    public static TimeZone getTimeZone(ZoneId zoneId) {
        String id = zoneId.getId();
        char charAt = id.charAt(0);
        if (charAt == '+' || charAt == '-') {
            id = "GMT" + id;
        } else if (charAt == 'Z' && id.length() == 1) {
            id = "UTC";
        }
        return TimeZone.getTimeZone(id);
    }

    public static ZoneId toZoneId(TimeZone timeZone) {
        return ZoneId.m112of(timeZone.getID(), ZoneId.SHORT_IDS);
    }
}
